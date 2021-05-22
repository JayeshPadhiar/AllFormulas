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

public class Maths extends Activity {

    private AdView MathAdView;
    String mathChapters[] = {"Sets", "Complex Numbers", "Quadratic Equations", "Matrices",
            "Permutation & Combination", "Binomial Theorem", "Sequence & Series", "Statistics", "Probability",
            "Differential Calculus", "Straight Lines", "Circles", "Trigonometry"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths);

        MathAdView = (AdView) findViewById(R.id.MathAdView);
        //mAdView.setAdSize(AdSize.SMART_BANNER);
        AdRequest adRequest = new AdRequest.Builder().build();
        MathAdView.loadAd(adRequest);

        ListAdapter mathAdapter = new ArrayAdapter<String>(this, R.layout.list_config, R.id.textView, mathChapters);
        ListView mathList = (ListView) findViewById(R.id.mathListView);
        mathList.setAdapter(mathAdapter);

        mathList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                String mathString = String.valueOf(parent.getItemAtPosition(position));
                                                Toast.makeText(Maths.this, mathString, Toast.LENGTH_SHORT).show();
                                                String formulaText;
                                                formulaText = mathChapters[position];
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
        if (MathAdView != null) {
            MathAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (MathAdView != null) {
            MathAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (MathAdView != null) {
            MathAdView.destroy();
        }
        super.onDestroy();
    }
}
