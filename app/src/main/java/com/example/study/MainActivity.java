package com.example.study;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.study.activity.lifecycle.LifecycleActivity;
import com.example.study.activity.mode.ModeActivity;
import com.example.study.activity.start.StartActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_start_activity).setOnClickListener(this);
        findViewById(R.id.btn_lifecycle_activity).setOnClickListener(this);
        findViewById(R.id.btn_mode_activity).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_activity:
                startActivity(new Intent(MainActivity.this, StartActivity.class));
                break;

            case R.id.btn_lifecycle_activity:
                LifecycleActivity.startAction(this);
                break;

            case R.id.btn_mode_activity:
                ModeActivity.startAction(this);
                break;
            default:
                break;
        }
    }
}
