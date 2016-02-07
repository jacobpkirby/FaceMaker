package com.example.jacob.facemaker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class MainActivity extends Activity implements View.OnClickListener {

    private FeatureColorManager colorManager;

    private Doodle doodle;


    //private EyeSpinner eyeSpinner;// // TODO:


    private HairSpinner hairSpinner;
    private NoseSpinner noseSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doodle = (Doodle) findViewById((R.id.surfaceView));



        colorManager = new FeatureColorManager(this, doodle);
        colorManager.onCreate(savedInstanceState);
        RadioGroup rg = (RadioGroup) findViewById(R.id.featureRG);
        rg.setOnCheckedChangeListener(colorManager);
        rg.check(R.id.HairRadioBtn);

        hairSpinner = new HairSpinner(doodle, this);
        noseSpinner = new NoseSpinner(doodle,this);

    }

    // on btn click
    // call hairspinner.random()
    // eyespinner.randiom()
    // whatevesels
    // THEN CALL INVALIDATE!!!


    @Override
    public void onClick(View v){



    }

}
