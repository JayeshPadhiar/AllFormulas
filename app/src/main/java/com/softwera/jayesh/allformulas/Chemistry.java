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

public class Chemistry extends Activity {

    private AdView ChemAdView;
    String chemChapters[] = {"Basic Concepts in Chemistry", "States of Matter", "Atomic Structure",
            "Chemical Bonding & Mol. Structure", "Chemical Thermodynamics", "Solutions", "Equilibrium",
            "Redox Reactions & Electrochemistry", "Surface Chemistry", "Classification of Elements"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemistry);

        ChemAdView = (AdView) findViewById(R.id.ChemAdView);
        //ChemAdView.setAdSize(AdSize.SMART_BANNER);
        AdRequest adRequest = new AdRequest.Builder().build();
        ChemAdView.loadAd(adRequest);

        ListAdapter chemAdapter = new ArrayAdapter<String>(this, R.layout.list_config, R.id.textView, chemChapters);
        ListView chemList = (ListView) findViewById(R.id.chemListView);
        chemList.setAdapter(chemAdapter);

        chemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                String chemString = String.valueOf(parent.getItemAtPosition(position));
                                                Toast.makeText(Chemistry.this, chemString, Toast.LENGTH_SHORT).show();
                                                String formulaText;
                                                formulaText = chemChapters[position];
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
        if (ChemAdView != null) {
            ChemAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (ChemAdView != null) {
            ChemAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (ChemAdView != null) {
            ChemAdView.destroy();
        }
        super.onDestroy();
    }
}
