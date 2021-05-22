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

public class Physics extends Activity {

    private AdView PhyAdView;
    String phyChapters[] = {"Kinematics", "Laws of Motion", "Work Power Energy", "Rotational Motion",
            "Gravitation", "Thermodynamics", "Kinetic Theory of Gases", "Properties of Matters",
            "Oscillations", "Waves and Sound","Circular Motion", "Elasticity", "Electrostatics", "Current & Electricity", "Heating Eff. of Current",
            "Magnetic Eff. of Current", "Magnetism", "Electromagnetic Induction", "Alternating Current",
            "Ray Optics", "Wave Optics", "Dual Nature of Matter"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics);

        PhyAdView = (AdView) findViewById(R.id.PhyAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        PhyAdView.loadAd(adRequest);

        ListAdapter phyAdapter = new ArrayAdapter<String>(this, R.layout.list_config, R.id.textView, phyChapters);
        ListView phyList = (ListView) findViewById(R.id.phyListView);
        phyList.setAdapter(phyAdapter);

        phyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String phyString = String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(Physics.this, phyString, Toast.LENGTH_SHORT).show();
                String formulaText;
                formulaText = phyChapters[position];
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
        if (PhyAdView != null) {
            PhyAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (PhyAdView != null) {
            PhyAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (PhyAdView != null) {
            PhyAdView.destroy();
        }
        super.onDestroy();
    }
}
