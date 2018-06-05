package com.aliouswang.battle.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.aliouswang.battle.util.L;

/**
 * Created by mac on 2018/5/31.
 */

public class MyConnection implements ServiceConnection{

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        L.e("on Service connected!");

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        L.e("on service disconnected!");
    }
}
