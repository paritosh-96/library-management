package com.example.srijanrana.librarymanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Srijan Rana on 10/22/2015.
 */
public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstaceState)
    {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_splash);
        Thread timer = new Thread() {
             public void run()
             {    try {
                    sleep(3000);
                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(i);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }


            }
        };

        timer.start();
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }


}
