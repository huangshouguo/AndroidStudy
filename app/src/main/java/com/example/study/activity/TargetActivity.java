package com.example.study.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.study.R;

public class TargetActivity extends AppCompatActivity {
    private static final String DATA_TAG = "args_data";

    public static void startAction(Context context) {
        Intent intent = new Intent(context, TargetActivity.class);
        context.startActivity(intent);
    }

    public static void startAction(Context context, String args) {
        Intent intent = new Intent(context, TargetActivity.class);
        intent.putExtra(DATA_TAG, args);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        String data = getIntent().getStringExtra("args_data");
        String text = "congratulations! welcome to this target activity";
        if (data != null) {
            text += (", got data: " + data);
        }

        ((TextView) findViewById(R.id.text_dashboard)).setText(text);

        findViewById(R.id.btn_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //返回数据
                intent.putExtra("data_return", "return data from target");

                //返回状态
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
