package com.example.jacob.facemaker;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.jacob.facemaker.feature.Face;
import com.example.jacob.facemaker.feature.eye.EyeFactory;
import com.example.jacob.facemaker.feature.eye.Eyes;
import com.example.jacob.facemaker.feature.hair.HairFactory;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Jacob on 2/7/2016.
 * This class is for the EyeSpinner. I decided to make it its own class and object because
 * it made the code more neat and for separation of concerns. This class creates the spinner
 * and also hold the method for generating a random Eye.
 */
public class EyeSpinner implements AdapterView.OnItemSelectedListener {


    private Activity activity;
    private Doodle doodle;
    private Spinner eyeSpinner;
    //makes a list of the array of strings that are found in the class EyeFactory which describes
    //the type of eyes the sure can select from
    List<String> options = Arrays.asList(EyeFactory.STYLES);
    /*
   Constructor - in order to have an eye spinner a surface view and activity must
   be sent in.
    */
    public EyeSpinner(Doodle doodle, Activity activity) {

        this.doodle = doodle;
        this.eyeSpinner = (Spinner) activity.findViewById(R.id.eyeSpinner);

        // configures the spinner and sets the array of options as its products.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, R.layout.support_simple_spinner_dropdown_item, options);
        eyeSpinner.setAdapter(adapter);
        eyeSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //When an item is selected it gets the face which is being used.
        Face face = doodle.getFace();
        int existingColor = doodle.getFace().getEyes().getColor();
        //gets the item selected from the spinner and sets it to newEyeStyle
        String newEyeStyle = options.get(position);
        //sets the selected eyes to the face using the function getInstance in EyeFactory which
        //tells which eye to create based off of the spinner selection the user pushes
        Eyes eyes = EyeFactory.getInstance(newEyeStyle);
        eyes.setColor(existingColor);
        face.setEyes(eyes);
        doodle.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    //not used
    }

    /*
    This method is used to generate a random style of eyes and is functioned when ever the
    random button is pushed
     */
    public void randomChoice() {

        Random r = new Random();
        int position = r.nextInt(3); // finds a random number between 0 - 2

        Face face = doodle.getFace(); // gets the current face

        //finds the color of the existing feature
        int existingColor = doodle.getFace().getEyes().getColor();
        String newEyeStyle;
        //gets the feature in the spinner that corresponds to the random position
        newEyeStyle = options.get(position);
        Eyes eye = EyeFactory.getInstance(newEyeStyle);
        //sets the color of the new eye style and sets the eyes on the face
        eye.setColor(existingColor);
        face.setEyes(eye);
        doodle.invalidate();

    }

}


