package com.softwera.jayesh.allformulas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class General extends Activity {

    private AdView mAdView;
    String genChapters[] = {"Algebraic or Expansion Formulas", "Some Tips & Trick for Quadratic Equation", "Basic Division Algorithm", "Laws of Indices",
            "Ratio & Proportion", "Surface Measurement", "Conversions"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ListAdapter genAdapter = new ArrayAdapter<String>(this, R.layout.list_config, R.id.textView, genChapters);
        ListView genList = (ListView) findViewById(R.id.genListView);
        genList .setAdapter(genAdapter);

        genList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                           @Override
                                           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                               String genString = String.valueOf(parent.getItemAtPosition(position));
                                               Toast.makeText(General.this, genString, Toast.LENGTH_SHORT).show();
                                               String formulaText;
                                               formulaText = genChapters[position];
                                               Intent showFormula = new Intent("com.softwera.jayesh.allformulas.FORMULAS");
                                               Bundle bundle = new Bundle();
                                               bundle.putString("formula", formulaText);
                                               showFormula.putExtras(bundle);
                                               startActivity(showFormula);
                                           }
                                       }
        );
    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

}

