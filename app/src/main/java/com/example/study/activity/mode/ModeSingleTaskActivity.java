package com.example.study.activity.mode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.study.R;

public class ModeSingleTaskActivity extends AppCompatActivity {

    public static void startAction(Context context){
        context.startActivity(new Intent(context, ModeSingleTaskActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_single_task);
        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModeSingleTaskAssitActivity.startAction(ModeSingleTaskActivity.this);
                ModeSingleTaskAssitActivity.startAction(ModeSingleTaskActivity.this);
                ModeSingleTaskAssitActivity.startAction(ModeSingleTaskActivity.this);
            }
        });
    }
}
