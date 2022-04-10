package dev.devcrew.backgroundservices;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationRequest;
import android.os.IBinder;
import android.widget.Toast;

import com.google.android.gms.location.LocationResult;

public class MyBackgroudSerces extends BroadcastReceiver {
     public static final String ACTION_PROCESS_UPDATE = "dev.devcrew.backgroundservices.UPDATE_LOCATION";


    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent!=null){
            final String action = intent.getAction();
            if (action.equals(ACTION_PROCESS_UPDATE)){
                LocationResult result = LocationResult.extractResult(intent);
                if (result!=null){
                    Location location = result.getLastLocation();
                    String locationString = new StringBuilder(""+location.getLatitude())
                            .append("/")
                            .append(location.getLongitude())
                            .toString();
                    try {
                        MainActivity.getInstance().updateTextView(locationString);

                    }catch (Exception e){
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            }
        }
    }
}