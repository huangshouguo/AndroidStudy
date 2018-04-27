package com.example.study.activity.mode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.study.R;

public class ModeActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "ModeActivity";

    public static void startAction(Context context) {
        context.startActivity(new Intent(context, ModeActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        findViewById(R.id.btn_standard).setOnClickListener(this);
        findViewById(R.id.btn_singleTop).setOnClickListener(this);
        findViewById(R.id.btn_singleTask).setOnClickListener(this);
        findViewById(R.id.btn_singleInstance).setOnClickListener(this);

        Log.d(TAG, "onCreate() called with: taskId = [" + getTaskId() + "]");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_standard:
                ModeStandardActivity.startAction(this);
                break;
            case R.id.btn_singleTop:
                ModeSingleTopActivity.startAction(this);
                break;
            case R.id.btn_singleTask:
                ModeSingleTaskActivity.startAction(this);
                break;
            case R.id.btn_singleInstance:
                ModeSingleInstanceActivity.startAction(this);
                break;
            default:
                break;
        }
    }
}
