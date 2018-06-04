package com.aliouswang.battle.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.aliouswang.battle.util.L;

/**
 * Created by aliouswang on 2018/5/31.
 */

public class MyService extends Service{

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        L.e("onBind");
        MyBinder binder = new MyBinder();
        L.e("onBind thread : " + Thread.currentThread().getName());
        return binder;
//        return null;
    }

    @Override
    public void onCreate() {
        L.e("onCreate");
        L.e("onCreate thread : " + Thread.currentThread().getName());
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        L.e("onStartCommand");
        L.e("onStartCommand thread : " + Thread.currentThread().getName());
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        L.e("onDestory");
        L.e("onDestroy thread : " + Thread.currentThread().getName());
        super.onDestroy();
    }

    private class MyBinder extends Binder {

    }
}
