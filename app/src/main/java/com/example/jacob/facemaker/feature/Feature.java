package com.example.jacob.facemaker.feature;

import android.graphics.Rect;

import com.example.jacob.facemaker.RatioLocation;

/**
 * Created by Jacob on 2/6/2016.
 * This is the interface for a Features. It makes it so each feature must have a color and a location.
 */
public interface Feature {

    public void setColor(int color);

    public int getColor();

    public void setLocation(RatioLocation location);

}
