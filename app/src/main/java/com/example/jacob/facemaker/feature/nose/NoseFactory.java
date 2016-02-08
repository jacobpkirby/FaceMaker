package com.example.jacob.facemaker.feature.nose;

/**
 * Created by Jacob on 2/7/2016.
 */
public class NoseFactory {


    public static final String OVAL = "Oval";
    public static final String CIRCLE = "Circle";
    public static final String TRIANGLE = "Triangle";
    public static final String[] STYLES = {
            "Oval", "Circle","Triangle"
    };

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
