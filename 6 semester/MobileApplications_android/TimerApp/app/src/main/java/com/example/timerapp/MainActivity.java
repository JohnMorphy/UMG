package com.example.timerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    private int totalSeconds = 0;
    private boolean isRealized = false;
    private boolean wasRealized = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null) {
            totalSeconds = savedInstanceState.getInt("totalSeconds");
            isRealized = savedInstanceState.getBoolean("isRealized");
            wasRealized = savedInstanceState.getBoolean("wasRealized");
        }
        runStopper();
    }

    @Override
    public void onSaveInstanceState(@NotNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("totalSeconds", totalSeconds);
        outState.putBoolean("isRealized", isRealized);
        outState.putBoolean("wasRealized", wasRealized);
    }

    public void start(View view) {
        isRealized = true;
    }

    public void stop(View view) {
        isRealized = false;
    }

    public void reset(View view) {
        isRealized = false;
        wasRealized = false;
        totalSeconds = 0;
    }

    private void runStopper() {
        final TextView display = findViewById(R.id.display);

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = totalSeconds/3600;
                int minutes = (totalSeconds%3600)/60;
                int seconds = totalSeconds%60;
                String time = String.format("%d:%02d:%02d", hours, minutes, seconds);
                display.setText(time);
                if(isRealized) {
                    totalSeconds++;
                }
                handler.postDelayed(this, 1000);
                //  start again after 1000 milliseconds
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(wasRealized) isRealized = true;
        Log.v("kom.1", "onResume is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRealized = isRealized;
        isRealized = false;
        Log.v("kom.2", "onPause called");
    }

}