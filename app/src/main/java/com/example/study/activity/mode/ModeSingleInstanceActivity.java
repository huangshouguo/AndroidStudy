package com.example.study.activity.mode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.study.R;

public class ModeSingleInstanceActivity extends AppCompatActivity {
    private static final String TAG = "ModeSingleInstanceActiv";

    public static void startAction(Context context) {
        context.startActivity(new Intent(context, ModeSingleInstanceActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_single_instance);
        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModeSingleInstanceAssitActivity.startAction(ModeSingleInstanceActivity.this);
            }
        });

        Log.i(TAG, "onCreate() called with: taskId = [" + this.getTaskId() + "]");
    }
}
