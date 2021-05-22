package com.softwera.jayesh.allformulas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Menu extends Activity {

    private AdView MenuAdView;

    Button Physics;
    Button Chemistry;
    Button Maths;
    Button General;
    FloatingActionButton About;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Physics = (Button) findViewById(R.id.btnPhysics);
        Chemistry = (Button) findViewById(R.id.btnChemistry);
        Maths = (Button) findViewById(R.id.btnMaths);
        General = (Button) findViewById(R.id.btnGeneral);
        About = (FloatingActionButton) findViewById(R.id.fAbout);


        Physics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openPhysics = new Intent("com.softwera.jayesh.allformulas.PHYSICS");
                startActivity(openPhysics);
            }
        });

        Chemistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openChem = new Intent("com.softwera.jayesh.allformulas.CHEMISTRY");
                startActivity(openChem);
            }
        });

        Maths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openMaths = new Intent("com.softwera.jayesh.allformulas.MATHS");
                startActivity(openMaths);
            }
        });

        General.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openGeneral = new Intent("com.softwera.jayesh.allformulas.GENERAL");
                startActivity(openGeneral);
            }
        });

        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openAbout = new Intent("com.softwera.jayesh.allformulas.ABOUT");
                startActivity(openAbout);
            }
        });


        MenuAdView = (AdView) findViewById(R.id.MenuAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        MenuAdView.loadAd(adRequest);

    }

    @Override
    public void onPause() {
        if (MenuAdView != null) {
            MenuAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (MenuAdView != null) {
            MenuAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (MenuAdView != null) {
            MenuAdView.destroy();
        }
        super.onDestroy();
    }
}

