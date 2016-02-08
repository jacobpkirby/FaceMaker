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

    private NormalEye leftEye = new NormalEye(50, 35, Color.GREEN);
    private NormalEye rightEye = new NormalEye(50, 35, Color.GREEN);

    public Eyes(int color) {
        this.color = color;
        leftEye.setColor(color);
        rightEye.setColor(color);
    }

    @Override
    public void draw(Canvas c) {
        Rect rect = c.getClipBounds();
        leftEye.setLocation(new RatioLocation(-0.25f, -0.25f, rect));
        rightEye.setLocation(new RatioLocation(0.25f, -0.25f, rect));

        leftEye.draw(c);
        rightEye.draw(c);
    }

    public void setColor(int color) {
        this.color = color;
        leftEye.setColor(color);
        rightEye.setColor(color);
    }
}
