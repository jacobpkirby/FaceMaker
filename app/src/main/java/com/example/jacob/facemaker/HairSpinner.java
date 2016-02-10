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
 * Created by Jacob  on 2/6/2016.
 * This class is for the HairSpinner. I decided to make it its own class and object because
 * it made the code more neat and for separation of concerns. This class creates the spinner
 * and also hold the method for generating a random Hair Style .
 */
public class HairSpinner implements AdapterView.OnItemSelectedListener{

    private Activity activity;
    private Doodle doodle;
    private Spinner spinner;
    //makes a list of the array of strings that are found in the class HairFactory which describes
    //the type of hair the sure can select from
    List<String> options = Arrays.asList(HairFactory.STYLES);

    /*
  Constructor - in order to have an hair spinner a surface view and activity must
  be sent in.
   */
    public HairSpinner(Doodle doodle, Activity activity) {

        this.doodle = doodle;
        this.spinner = (Spinner) activity.findViewById(R.id.hairSpinner);

        // configures the spinner and sets the array of options as its products.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, R.layout.support_simple_spinner_dropdown_item, options);
        spinner.setAdapter(adapter);

        // set this class as the item listener
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //When an item is selected it gets the face which is being used.
        Face face = doodle.getFace();
        //gets current color of hair
        int existingColor = doodle.getFace().getHair().getColor();
        //sets the newHairStyle to the item selected by the user
        String newHairStyle = options.get(position);
        //creates the hair and  sets it to to the face
        Hair hair = HairFactory.getInstance(newHairStyle);
        hair.setColor(existingColor);
        face.setHair(hair);
        doodle.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //not used
    }

    /*
    This method generates a random hair style when the random button is pushed
     */
    public void randomChoice() {
        Random r = new Random();
        int position = r.nextInt(3); // find a random number between 0 - 2

        //gets current face
        Face face = doodle.getFace();

        //Finds current color of the hair style
        int existingColor = doodle.getFace().getHair().getColor();
        String newHairStyle;
        //sets the randomly selected value as the hair feature then sets its it to the face
        newHairStyle = options.get(position);
        Hair hair = HairFactory.getInstance(newHairStyle);
        hair.setColor(existingColor);
        face.setHair(hair);
        doodle.invalidate();


    }

}
