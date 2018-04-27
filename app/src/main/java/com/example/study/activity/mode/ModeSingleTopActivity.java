package com.example.study.activity.mode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.study.R;

public class ModeSingleTopActivity extends AppCompatActivity {
    private static final String TAG = "ModeSingleTopActivity";

    public static void startAction(Context context) {
        context.startActivity(new Intent(context, ModeSingleTopActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_single_top);

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ModeSingleTopActivity.this, ModeSingleTopActivity.class));
            }
        });

        Log.w(TAG, "onCreate() called");
    }
}
