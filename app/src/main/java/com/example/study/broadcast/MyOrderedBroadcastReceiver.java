package com.example.study.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyOrderedBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "My Ordered Broadcast Receiver", Toast.LENGTH_LONG).show();
        abortBroadcast();
    }
}
