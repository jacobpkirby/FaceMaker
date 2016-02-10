package com.example.jacob.facemaker.feature;

import android.graphics.Rect;

import com.example.jacob.facemaker.RatioLocation;

/**
 * Created by Jacob on 2/6/2016.
 * This is the interface for a Features.  a feature is an element on your face, every
 * element must be a feature and have the methods setColor,getColor, and setLocation
 */
public interface Feature {

    public void setColor(int color);

    public int getColor();

    public void setLocation(RatioLocation location);

}
