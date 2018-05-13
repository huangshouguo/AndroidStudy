package com.example.study.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.study.R;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "ServiceActivity";

    public static void startAction(Context context) {
        context.startActivity(new Intent(context, ServiceActivity.class));
    }


    private MyBinder myBinder;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected() called");
            myBinder = (MyBinder) service;
            myBinder.startDownload();
            myBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected() called");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        findViewById(R.id.btn_start_service).setOnClickListener(this);
        findViewById(R.id.btn_stop_service).setOnClickListener(this);
        findViewById(R.id.btn_bind_service).setOnClickListener(this);
        findViewById(R.id.btn_unbind_service).setOnClickListener(this);
        findViewById(R.id.btn_start_intent_service).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_service:
                startService(new Intent(this, MyService.class));
                break;
            case R.id.btn_stop_service:
                stopService(new Intent(this, MyService.class));
                break;
            case R.id.btn_bind_service:
                bindService(new Intent(this, MyService.class), this.serviceConnection, BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind_service:
                unbindService(this.serviceConnection);
                break;
            case R.id.btn_start_intent_service:
                Log.d(TAG, "start intent service called with: thread id is: [" + Thread.currentThread().getId() + "]");
                startService(new Intent(this, MyIntentService.class));
                break;
            default:
                break;
        }
    }
}
