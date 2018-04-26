package com.example.study.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.study.R;

public class TargetActivity extends AppCompatActivity {

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
                intent.putExtra("data_return", "return data from target");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
