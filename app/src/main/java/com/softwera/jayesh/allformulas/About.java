package com.softwera.jayesh.allformulas;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class About extends Activity {

    TextView AboutMe, DownloadPro;
    Button rateAllFormulas, allFormulasPro, instaFollow, reqButton;
    String allFromulas = "com.softwera.jayesh.allformulas";
    String allFormulasProUrl = "com.softwera.jayesh.allformulaspro";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        AboutMe = (TextView) findViewById(R.id.allAboutMe);
        DownloadPro = (TextView) findViewById(R.id.proVersionText);

        rateAllFormulas = (Button) findViewById(R.id.rateMyApp);
        allFormulasPro = (Button) findViewById(R.id.proVersionButton);
        //instaFollow = (Button) findViewById(R.id.instaButton);
        reqButton = (Button) findViewById(R.id.reqButton);

        AboutMe.setText("Developed by Jayesh Padhiar");
        DownloadPro.setText("Download Pro Version of this App and get MORE FORMULAS and NO ADS.  \n\n Thank You !!!");

        rateAllFormulas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + allFromulas)));
                }catch(ActivityNotFoundException afne){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + allFromulas)));
                }
            }
        });

        allFormulasPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + allFormulasProUrl)));
                }catch(ActivityNotFoundException afne){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + allFormulasProUrl)));
                }
            }
        });

        reqButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myRequest = new Intent("com.softwera.jayesh.allformulas.REQUEST");
                startActivity(myRequest);
            }
        });

        /*instaFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    Uri instaUri = Uri.parse("http://instagram.com/_u/jayesh.padhiar");
                    Intent instent = new Intent (Intent.ACTION_VIEW, instaUri);
                    instent.setPackage("com.instagram.android");
                    startActivity(instent);

                    //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/jayesh.padhiar")));

                }catch(ActivityNotFoundException afne){

                    //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/jayesh.padhiar")));
                }
            }
        });*/



    }
}
