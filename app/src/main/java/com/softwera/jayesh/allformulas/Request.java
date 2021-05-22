package com.softwera.jayesh.allformulas;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Request extends Activity {

    TextView Request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        Request = (TextView) findViewById(R.id.reqText);

        Request.setText("Please download the Pro Version to get more formulas and less ads.");

    }
}