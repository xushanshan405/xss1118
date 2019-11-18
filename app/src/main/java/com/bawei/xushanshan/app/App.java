package com.bawei.xushanshan.app;

import android.app.Application;
import android.content.Context;

/**
 * FileName: App
 * Author: 徐姗姗
 * Date: 2019/11/18 9:43
 */
public class App extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
