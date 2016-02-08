package com.example.jacob.facemaker;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.jacob.facemaker.feature.Face;
import com.example.jacob.facemaker.feature.nose.Nose;
import com.example.jacob.facemaker.feature.nose.NoseFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Jacob on 2/7/2016.
 */
public class NoseSpinner implements AdapterView.OnItemSelectedListener{

    private Activity activity;
    private Doodle doodle;
    private Spinner spinner;
    List<String> options = Arrays.asList(NoseFactory.STYLES);

    public NoseSpinner(Doodle doodle, Activity activity) {

        this.doodle = doodle;
        this.spinner = (Spinner) activity.findViewById(R.id.noseSpinner);

        // configure spinner data source
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, R.layout.support_simple_spinner_dropdown_item, options);
        spinner.setAdapter(adapter);

        // set this class as the item listener
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Face face = doodle.getFace();
        int existingColor = doodle.getFace().getNose().getColor();
        String newNoseStyle = options.get(position);



        Nose nose = NoseFactory.getInstance(newNoseStyle);
        nose.setColor(existingColor);
        face.setNose(nose);


        doodle.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void randomChoice() {
        Random r = new Random();
        int position = r.nextInt(3); // 0 - 2

        Face face = doodle.getFace();

        System.out.println(position);
        int existingColor = doodle.getFace().getNose().getColor();
        String newNoseStyle;
        newNoseStyle = options.get(position);
        Nose nose = NoseFactory.getInstance(newNoseStyle);
        nose.setColor(existingColor);
        face.setNose(nose);
        doodle.invalidate();

        //newHairStyle = options.get(position);
        //face.setHair(HairFactory.getInstance(newHairStyle));



    }


}
