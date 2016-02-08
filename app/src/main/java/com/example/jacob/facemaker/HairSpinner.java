package com.example.jacob.facemaker;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.jacob.facemaker.feature.Face;
import com.example.jacob.facemaker.feature.hair.Hair;
import com.example.jacob.facemaker.feature.hair.HairFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by peter on 2/6/2016.
 */
public class HairSpinner implements AdapterView.OnItemSelectedListener{

    private Activity activity;
    private Doodle doodle;
    private Spinner spinner;
    List<String> options = Arrays.asList(HairFactory.STYLES);

    public HairSpinner(Doodle doodle, Activity activity) {

        this.doodle = doodle;
        this.spinner = (Spinner) activity.findViewById(R.id.hairSpinner);

        // configure spinner data source
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, R.layout.support_simple_spinner_dropdown_item, options);
        spinner.setAdapter(adapter);

        // set this class as the item listener
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Face face = doodle.getFace();

        int existingColor = doodle.getFace().getHair().getColor();
        String newHairStyle = options.get(position);
        Hair hair = HairFactory.getInstance(newHairStyle);
        hair.setColor(existingColor);
        face.setHair(hair);


        //face.setHair(HairFactory.getInstance(newHairStyle));
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
        int existingColor = doodle.getFace().getHair().getColor();
        String newHairStyle;
        newHairStyle = options.get(position);
        Hair hair = HairFactory.getInstance(newHairStyle);
        hair.setColor(existingColor);
        face.setHair(hair);
        doodle.invalidate();

        //newHairStyle = options.get(position);
        //face.setHair(HairFactory.getInstance(newHairStyle));



    }

}
