package com.example.gps_and_services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class RandomNumber_Generator extends Service {

    Random random = new Random();


    public RandomNumber_Generator() {
    }

    private final IBinder serviceConnection = new ServiceConnection();
    public class ServiceConnection extends Binder {
        RandomNumber_Generator getService() {
            return RandomNumber_Generator.this;
        }
    }

    public int generateNumber(){
        return random.nextInt(100);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return serviceConnection;
    }
}