package com.example.gps_and_services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean bound;
    private RandomNumber_Generator randomNumberService;
    private GPS gpsService;

    private Intent randomNumberIntent;
    private Intent gpsIntent;
    int sum;

    final Handler generatorHandler = new Handler();

    boolean isHandlerRunning = false;


    private TextView informationBar;
    private TextView randomNumberDisplay;
    private TextView sumDisplay;

    private TextView gpsData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sum = 0;

        this.informationBar = findViewById(R.id.informationBar);
        this.randomNumberDisplay = findViewById(R.id.randomValueDisplay);
        this.sumDisplay = findViewById(R.id.sumDisplay);
        this.gpsData = findViewById(R.id.gpsData);

    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    private final ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName cName, IBinder binder) {
            if (cName.getClassName().equals(RandomNumber_Generator.class.getName())) {
                RandomNumber_Generator.ServiceConnection serviceConnection1 =
                        (RandomNumber_Generator.ServiceConnection) binder;
                randomNumberService = serviceConnection1.getService();
            } else if (cName.getClassName().equals(GPS.class.getName())) {
                GPS.ServiceConnection serviceConnection2 =
                        (GPS.ServiceConnection) binder;
                gpsService = serviceConnection2.getService();
            }

            bound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            randomNumberService = null;
            gpsService = null;
            bound = false;
        }
    };


    public void bind(View view) {
        if (!bound) {
            randomNumberIntent = new Intent(this, RandomNumber_Generator.class);
            bindService(randomNumberIntent, connection, Context.BIND_AUTO_CREATE);

            gpsIntent = new Intent(this, GPS.class);
            bindService(gpsIntent, connection, Context.BIND_AUTO_CREATE);

            informationBar.setText("Services bound");
        } else {
            informationBar.setText("Services already bound");
        }
    }


    public void unbind(View view) {
        if (bound) {
            stopService(gpsIntent);
            stopService(randomNumberIntent);
            unbindService(connection);
            informationBar.setText("Service unbound");
            bound = false;
        } else {
            informationBar.setText("Service already unbounded");
        }
    }

    public void testServiceConnection(View view) {
        if(!bound) {
            this.informationBar.setText("Service is not bound");
        } else {
            int value = randomNumberService.generateNumber();
            String text = "Random number generator: " + value;
            this.informationBar.setText(text);
        }
    }

    public void runGenerator(View view) {
        if(bound) {
            isHandlerRunning = true;
            generatorHandler.post(new Runnable() {
                @Override
                public void run() {
                    int value = randomNumberService.generateNumber();
                    sum += value;
                    randomNumberDisplay.setText("Random number: " + value);
                    sumDisplay.setText("sum = " + sum);


                    Location location =
                    gpsData.setText("");

                    if(isHandlerRunning) {
                        generatorHandler.postDelayed(this, 1000);
                    }
                }
            });

        } else if(isHandlerRunning) {
            isHandlerRunning = false;
            randomNumberDisplay.setText("Stopped running");
            sumDisplay.setText("");

            gpsData.setText("location: --- \n latitude: --- \n longitude: --- \n height: --- \n distance in meters: --- \n distance travelled: ---");
        } else {
            informationBar.setText("Services are not bound");
        }

    }





}