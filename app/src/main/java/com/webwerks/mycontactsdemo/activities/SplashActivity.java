package com.webwerks.mycontactsdemo.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.webwerks.mycontactsdemo.R;
import com.webwerks.mycontactsdemo.comman.Constant;


/**
 * Created by webwerks on 24/01/18.
 */

public class SplashActivity extends AppCompatActivity {
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intentLogin = new Intent(SplashActivity.this,ContactsActivity.class);
                startActivity(intentLogin);
                finish();
            }
        }, Constant.SPLASH_DISPLAY_LENGTH);


    }
}
