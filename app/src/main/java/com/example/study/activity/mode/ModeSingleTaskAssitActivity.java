package com.example.study.activity.mode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.study.R;

public class ModeSingleTaskAssitActivity extends AppCompatActivity {
    private static final String TAG = "ModeSingleTaskAssitActi";

    public static void startAction(Context context) {
        context.startActivity(new Intent(context, ModeSingleTaskAssitActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_single_task_assit);
        findViewById(R.id.btn_jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModeSingleTaskActivity.startAction(ModeSingleTaskAssitActivity.this);
            }
        });

        Log.d(TAG, "onCreate() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w(TAG, "onDestroy() called");
    }
}
