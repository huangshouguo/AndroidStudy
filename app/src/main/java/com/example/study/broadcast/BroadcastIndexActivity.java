package com.example.study.broadcast;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.study.R;

public class BroadcastIndexActivity extends AppCompatActivity implements View.OnClickListener {

    private IntentFilter intentFilter;
    private LocalBroadcastReceiver localBroadcastReceiver;
    private LocalBroadcastManager localBroadcastManager;

    public static void startAction(Context context) {
        context.startActivity(new Intent(context, BroadcastIndexActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_index);

        findViewById(R.id.btn_dynamic_broadcast).setOnClickListener(this);
        findViewById(R.id.btn_standard_broadcast).setOnClickListener(this);
        findViewById(R.id.btn_ordered_broadcast).setOnClickListener(this);
        findViewById(R.id.btn_local_broadcast).setOnClickListener(this);



        this.intentFilter = new IntentFilter();
        this.intentFilter.addAction("com.example.broadcast.MY_LOCAL_BROADCAST");
        this.localBroadcastManager = LocalBroadcastManager.getInstance(this);
        this.localBroadcastReceiver = new LocalBroadcastReceiver();
        this.localBroadcastManager.registerReceiver(this.localBroadcastReceiver, this.intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.localBroadcastManager.unregisterReceiver(this.localBroadcastReceiver);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_dynamic_broadcast:
                BroadcastDynamicSystemActivity.startAction(this);
                break;
            case R.id.btn_standard_broadcast:
                sendBroadcast(new Intent("com.example.broadcast.MY_BROADCAST"));
                break;
            case R.id.btn_ordered_broadcast:
                sendOrderedBroadcast(new Intent("com.example.broadcast.MY_BROADCAST"), null);
                break;
            case R.id.btn_local_broadcast:
                this.localBroadcastManager.sendBroadcast(new Intent("com.example.broadcast.MY_LOCAL_BROADCAST"));
                break;
            default:
                break;
        }
    }
}
