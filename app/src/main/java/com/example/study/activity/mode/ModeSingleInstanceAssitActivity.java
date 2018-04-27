package com.example.study.activity.mode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.study.R;

public class ModeSingleInstanceAssitActivity extends AppCompatActivity {
    private static final String TAG = "ModeSingleInstanceAssit";

    public static void startAction(Context context) {
        context.startActivity(new Intent(context, ModeSingleInstanceAssitActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_single_instance_assit);

        Log.i(TAG, "onCreate() called with: taskId = [" + this.getTaskId() + "]");
    }
}
