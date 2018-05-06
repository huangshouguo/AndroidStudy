package com.example.study.broadcast;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.study.R;

public class BroadcastDynamicSystemActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;

    public static void startAction(Context context) {
        context.startActivity(new Intent(context, BroadcastDynamicSystemActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_dynamic_system);

        //register network change broadcast receiver
        this.intentFilter = new IntentFilter();
        this.intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.networkChangeReceiver = new NetworkChangeReceiver();

        registerReceiver(this.networkChangeReceiver, this.intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //unregister network change broadcast receiver
        unregisterReceiver(this.networkChangeReceiver);
    }
}