package com.example.jacob.facemaker.feature.eye;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;

import com.example.jacob.facemaker.RatioLocation;
import com.example.jacob.facemaker.feature.AbstractFeature;
import com.example.jacob.facemaker.feature.Feature;

/**
 * Created by jacob on 2/6/2016.
 * This class is used to assign the placement of the eyes and to give them their color.
 * This class draws each eye.
 */
public class Eyes extends AbstractFeature implements Feature {

    private Eye leftEye;
    private Eye rightEye;

    //to be an eye, 2 eyes must be passed in with a color
    public Eyes(Eye leftEye, Eye rightEye, int color) {
        this.color = color;
        this.leftEye = leftEye;
        this.rightEye = rightEye;
        this.leftEye.setColor(color);
        this.rightEye.setColor(color);
    }

    public Eyes(int color) {
        this.color = color;
        leftEye.setColor(color);
        rightEye.setColor(color);
    }

    @Override
    public void draw(Canvas c) {
        //rect is the surface view
        Rect rect = c.getClipBounds();
        //left and right eye are set to a location based off of the RationLocation
        leftEye.setLocation(new RatioLocation(-0.25f, -0.25f, rect));
        rightEye.setLocation(new RatioLocation(0.25f, -0.25f, rect));

        leftEye.draw(c);
        rightEye.draw(c);
    }

    //sets the color of each eye
    public void setColor(int color) {
        this.color = color;
        leftEye.setColor(color);
        rightEye.setColor(color);
    }



}
