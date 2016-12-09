package com.zeroli.common.baseapp;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.support.multidex.MultiDex;

/**
 * Created by zhh_li on 2016/10/14.
 */

public class BaseApplication extends Application {

    private  static BaseApplication sBaseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sBaseApplication = this;
    }

    public static Context getAppContext(){
        return sBaseApplication;
    }

    public static Resources getAppResourse(){
        return sBaseApplication.getResources();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);//分包
    }
}
