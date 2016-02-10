package com.example.jacob.facemaker.feature.eye;


import android.graphics.Color;

/**
 * Created by Jacob on 2/6/2016.
 * This is where the eyes are selected. Each eye possibility is shown here and is made if
 * the name is selected from the spinner.
 */
public class EyeFactory {
    public static final String CRAZY = "Crazy";
    public static final String NORMAL = "Normal";
    public static final String SMALL = "Small";
    public static final String[] STYLES = {NORMAL,CRAZY,SMALL};

    //This method gets the selected string for the spinner that that been selected and finds the
    // corresponding type of eye.
    public static Eyes getInstance(String name) {

        if (name.equals(NORMAL)) {
            return new Eyes(new Eye(50, 35),new Eye(50, 35),Color.GREEN);
        }  else if (name.equals(CRAZY)) {
            return new Eyes(new Eye(25, 100),new Eye(25, 100),Color.GREEN);
        } else if (name.equals(SMALL)) {
            return new Eyes(new Eye(25, 25),new Eye(25, 25),Color.GREEN);
        } else {
            throw new IllegalArgumentException("Invalid hair style name: ");
        }

    }


}
