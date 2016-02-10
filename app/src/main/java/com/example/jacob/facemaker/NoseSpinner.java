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
 * This class is for the NoseSpinner. I decided to make it its own class and object because
 * it made the code more neat and for separation of concerns. This class creates the spinner
 * and also hold the method for generating a random nose Style .
 */
public class NoseSpinner implements AdapterView.OnItemSelectedListener{

    private Activity activity;
    private Doodle doodle;
    private Spinner noseSpinner;
    //makes a list of the array of strings that are found in the class NoseFactory which describes
    //the type of nose the sure can select from
    List<String> options = Arrays.asList(NoseFactory.STYLES);

    /*
    Constructor - in order to have an nose spinner a surface view and activity must
    be sent in.
    */
    public NoseSpinner(Doodle doodle, Activity activity) {

        this.doodle = doodle;
        this.noseSpinner = (Spinner) activity.findViewById(R.id.noseSpinner);

        // configures the spinner and sets the array of options as its products.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, R.layout.support_simple_spinner_dropdown_item, options);
        noseSpinner.setAdapter(adapter);


        noseSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //When an item is selected it gets the face which is being used.
        Face face = doodle.getFace();
        //gets current color of nose
        int existingColor = doodle.getFace().getNose().getColor();
        //sets the newNoseStyle to the item selected by the user
        String newNoseStyle = options.get(position);
        //creates the nose and  sets it to to the face
        Nose nose = NoseFactory.getInstance(newNoseStyle);
        nose.setColor(existingColor);
        face.setNose(nose);
        doodle.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    /*
    This method generates a random hair style when the random button is pushed
    */
    public void randomChoice() {
        Random r = new Random();
        int position = r.nextInt(3); // finds a random number between 0 - 2
        //gets the current face
        Face face = doodle.getFace();

        //gets current color of nose
        int existingColor = doodle.getFace().getNose().getColor();
        //sets the newNoseStyle to the item selected by the user
        String newNoseStyle = options.get(position);
        //creates the nose and  sets it to to the face
        Nose nose = NoseFactory.getInstance(newNoseStyle);
        nose.setColor(existingColor);
        face.setNose(nose);
        doodle.invalidate();


    }


}
