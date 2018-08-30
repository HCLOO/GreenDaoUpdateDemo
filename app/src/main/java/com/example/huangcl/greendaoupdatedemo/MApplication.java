package com.example.huangcl.greendaoupdatedemo;

import android.app.Application;
import android.content.Context;

public class MApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
    }

    public static Context getContext() {
        return mContext;
    }
}
