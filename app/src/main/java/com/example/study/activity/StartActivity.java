package com.example.study.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.study.R;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        findViewById(R.id.btn_explicit_start).setOnClickListener(this);
        findViewById(R.id.btn_arguments_explicit_start).setOnClickListener(this);
        findViewById(R.id.btn_explicit_start_result).setOnClickListener(this);
        findViewById(R.id.btn_arguments_explicit_start_result).setOnClickListener(this);

        findViewById(R.id.btn_implicit_start).setOnClickListener(this);
        findViewById(R.id.btn_arguments_implicit_start).setOnClickListener(this);
        findViewById(R.id.btn_implicit_start_result).setOnClickListener(this);
        findViewById(R.id.btn_arguments_implicit_start_result).setOnClickListener(this);

        findViewById(R.id.btn_implicit_start_dial).setOnClickListener(this);
        findViewById(R.id.btn_implicit_start_web).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView dashboard = findViewById(R.id.text_dashboard);
        dashboard.setText("no data at all!");

        switch (v.getId()) {
            case R.id.btn_explicit_start: {
                this.startActivity(new Intent(this, TargetActivity.class));
            }
            break;

            case R.id.btn_arguments_explicit_start: {
                Intent intent = new Intent(this, TargetActivity.class);
                intent.putExtra("args_data", "data from start activity with explicit");
                this.startActivity(intent);
            }
            break;

            case R.id.btn_explicit_start_result: {
                this.startActivityForResult(new Intent(this, TargetActivity.class), 1);
            }
            break;

            case R.id.btn_arguments_explicit_start_result: {
                Intent intent = new Intent(this, TargetActivity.class);
                intent.putExtra("args_data", "data from start activity for result with explicit");
                this.startActivityForResult(intent, 1);
            }
            break;

            case R.id.btn_implicit_start: {
                this.startActivity(new Intent("com.example.study.START_ACTION"));
            }
            break;

            case R.id.btn_arguments_implicit_start: {
                Intent intent = new Intent("com.example.study.START_ACTION");
                intent.putExtra("args_data", "data from start activity with implicit");
                this.startActivity(intent);
            }
            break;

            case R.id.btn_implicit_start_result: {
                this.startActivityForResult(new Intent("com.example.study.START_ACTION"), 1);
            }
            break;

            case R.id.btn_arguments_implicit_start_result: {
                Intent intent = new Intent("com.example.study.START_ACTION");
                intent.putExtra("args_data", "data from start activity for result with implicit");
                this.startActivityForResult(intent, 1);
            }
            break;

            case R.id.btn_implicit_start_dial: {//拨号
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
            break;

            case R.id.btn_implicit_start_web: {//打开网页
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
            break;

            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                ((TextView) findViewById(R.id.text_dashboard)).setText("got data: " + data.getStringExtra("data_return"));
            }
        }
    }
}