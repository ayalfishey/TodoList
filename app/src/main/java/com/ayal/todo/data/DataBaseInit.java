package com.ayal.todo.data;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class DataBaseInit extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
