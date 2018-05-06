package com.example.study.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        //get the state of network
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        String state;
        if (networkInfo != null && networkInfo.isAvailable()) {
            state = "available";
        } else {
            state = "unavailable";
        }

        Toast.makeText(context, "Network is " + state, Toast.LENGTH_LONG).show();
    }
}
