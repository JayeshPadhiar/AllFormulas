// Code by Jayesh Padhiar for Cancerous Logics (Softwera Labs)
// This Code is Copyrighted so Fuk Yu.

package com.softwera.jayesh.allformulas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {

    Thread timer = new Thread(){
        public void run(){
            try{
                sleep(3000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally{
                Intent openMenu = new Intent("com.softwera.jayesh.allformulas.MENU");
                startActivity(openMenu);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}