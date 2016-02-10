package com.example.jacob.facemaker.feature.nose;

/**
 * Created by Jacob on 2/7/2016.
 *  This is where the nose is selected. Each nose possibility is shown here and is made if
 * the name is selected from the spinner.
 */
public class NoseFactory {


    public static final String OVAL = "Oval";
    public static final String CIRCLE = "Circle";
    public static final String TRIANGLE = "Triangle";
    public static final String[] STYLES = {"Oval", "Circle","Triangle"};

    /*
    This method finds what String is entered from the spinner and places it with the correct
    hair style.
     */
    public static Nose getInstance(String name) {

        if (name.equals(OVAL)) {
            return new OvalNose();
        }else if (name.equals(CIRCLE)) {
            return new CircleNose();
        }else if (name.equals(TRIANGLE)) {
            return new TriangleNose();

            }  else {
            throw new IllegalArgumentException("Invalid hair style name: " + name);
        }

    }
}
