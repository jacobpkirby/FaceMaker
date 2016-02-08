package com.example.jacob.facemaker.feature.eye;



/**
 * Created by Jacob on 2/6/2016.
 * This is where the eyes are selected. Each eye possibility is shown here and is made if
 * the name is selected from the spinner.
 */
public class EyeFactory {
    public static final String SPIKED = "Spiked";
    public static final String NORMAL = "Normal";
    public static final String SHORT = "Short";
    public static final String[] STYLES = {
             "Normal"
    };

    public static Eye getInstance(String name) {

        if (name.equals(NORMAL)) {
            return new NormalEye();



        }  else {
            throw new IllegalArgumentException("Invalid hair style name: " + name);
        }

    }


}
