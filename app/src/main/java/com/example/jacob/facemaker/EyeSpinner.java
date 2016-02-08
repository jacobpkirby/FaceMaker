package com.example.jacob.facemaker;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.jacob.facemaker.feature.Face;
import com.example.jacob.facemaker.feature.eye.EyeFactory;
import com.example.jacob.facemaker.feature.hair.HairFactory;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Jacob on 2/7/2016.
 */
public class EyeSpinner implements AdapterView.OnItemSelectedListener {

    private Activity activity;
    private Doodle doodle;
    private Spinner spinner;
    List<String> options = Arrays.asList(EyeFactory.STYLES);

    public EyeSpinner(Doodle doodle, Activity activity) {

        this.doodle = doodle;
        this.spinner = (Spinner) activity.findViewById(R.id.eyeSpinner);

        // configure spinner data source
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, R.layout.support_simple_spinner_dropdown_item, options);
        spinner.setAdapter(adapter);

        // set this class as the item listener
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Face face = doodle.getFace();
        String newEyeStyle = options.get(position);
        //face.setEyes(EyeFactory.getInstance(newEyeStyle));
        doodle.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void randomChoice() {
        Random r = new Random();
        int position = r.nextInt(3); // 0 - 2

        Face face = doodle.getFace();
        String newEyeStyle = options.get(position);
        face.setHair(HairFactory.getInstance(newEyeStyle));
        doodle.invalidate();


    }

}


