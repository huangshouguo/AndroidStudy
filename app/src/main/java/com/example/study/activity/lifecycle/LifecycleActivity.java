package com.example.study.activity.lifecycle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.study.R;

public class LifecycleActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "LifecycleActivity";

    public static void startAction(Context context) {
        context.startActivity(new Intent(context, LifecycleActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        Log.d(TAG, "onCreate() called");

        findViewById(R.id.btn_activity).setOnClickListener(this);
        findViewById(R.id.btn_activity_dialog).setOnClickListener(this);
        findViewById(R.id.btn_dialog).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() called");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_activity:
                Lifecycle2Activity.startAction(this);
                break;
            case R.id.btn_activity_dialog:
                LifecycleDialogActivity.startAction(this);
                break;
            case R.id.btn_dialog:
                showAlertDialog();
                break;
            default:
                break;
        }
    }

    private void showAlertDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Alert Dialog Title")
                .setMessage("The message content of this alert dialog!")
                .setPositiveButton("ok", null)
                .setNegativeButton("cancel", null)
                .create()
                .show();
    }
}
