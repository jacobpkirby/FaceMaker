/*
-----------------------------------------------------------------------------------
Program: FaceMaker
Author: Jacob Kirby
Date: 02/08/2016

Resources: Peter Kirby - My brother helped me structure this program so that it would be orginized
    by separation of concern. He also helped me with locating where to put each feature on the
    surface view. Specifically he helped me with the logic found in the RatioLocation class.

    http://developer.android.com/index.html - I used this website multiple times to understand
    different classes, methods, and interfaces for andriod and java









-------------------------------------------------------------------------------------
 */




package com.example.jacob.facemaker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends Activity implements View.OnClickListener {


    /*
    Creates a featureColorManager which handles the colors of the app.
    I decided to make this new class becasuse of serpeartion of concerns and to make
    the code more organized.
    */
    private FeatureColorManager colorManager;
    //creates the surfaceView
    private Doodle doodle;
    //creates the 3 spinners used in this program.
    private EyeSpinner eyeSpinner;
    private HairSpinner hairSpinner;
    private NoseSpinner noseSpinner;
    //Random button used to generate random features
    private Button randomButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doodle = (Doodle) findViewById((R.id.surfaceView));

        randomButton = (Button)findViewById(R.id.randomButton);
        randomButton.setOnClickListener(this);

        colorManager = new FeatureColorManager(this, doodle);
        colorManager.onCreate(savedInstanceState);

        RadioGroup rg = (RadioGroup) findViewById(R.id.featureRG);
        rg.setOnCheckedChangeListener(colorManager);
        rg.check(R.id.HairRadioBtn);

        hairSpinner = new HairSpinner(doodle, this);
        noseSpinner = new NoseSpinner(doodle,this);
        eyeSpinner = new EyeSpinner(doodle,this);



    }

    @Override
    public void onClick(View v){
        //When the random button is pushed all the random functions are called in each
        // spinner class
        if(v.getId() == R.id.randomButton){
            hairSpinner.randomChoice();
            noseSpinner.randomChoice();
            eyeSpinner.randomChoice();
        }
    }


}
