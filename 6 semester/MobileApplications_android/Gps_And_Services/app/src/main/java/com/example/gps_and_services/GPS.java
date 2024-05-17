package com.example.gps_and_services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class GPS extends Service {
    public GPS() {
    }
    Location lastLocation;
    double latitude;
    double longitude;
    double height;
    double distanceInMeters;
    double distanceSum = 0;

    LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location currentLocation) {
            if(lastLocation == null) {
                lastLocation = currentLocation;
            }
            latitude = currentLocation.getLatitude();
            longitude = currentLocation.getLongitude();
            height = currentLocation.getAltitude();
            distanceInMeters = currentLocation.distanceTo(lastLocation);
            distanceSum += distanceInMeters;
            lastLocation = currentLocation;
        }
    };

    public void updateLocation() {
        try {
            locationManager.requestLocationUpdates("gps",1000,2, locationListener);
        }
        catch (SecurityException se) {
            Log.v("unavailable","No permission");
        }
    }

    private final IBinder serviceConnection = new GPS.ServiceConnection();
    public class ServiceConnection extends Binder {
        GPS getService() {
            return GPS.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return serviceConnection;
    }

}