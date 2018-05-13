package com.example.study.service;

import android.os.Binder;
import android.util.Log;

public class MyBinder extends Binder {
    private static final String TAG = "MyBinder";

    //自定义执行任务的方法
    public void startDownload() {
        Log.d(TAG, "startDownload() called");
    }

    //自定义获取进度
    public int getProgress() {
        Log.d(TAG, "getProgress() called");
        return 0;
    }
}
