package com.aliouswang.battle;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.aliouswang.battle.service.MyService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent service = new Intent(this, MyService.class);
        startService(service);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                stopService(service);
            }
        }, 3000);
    }

