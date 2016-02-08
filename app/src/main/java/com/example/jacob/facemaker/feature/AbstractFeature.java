package com.example.jacob.facemaker.feature;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import com.example.jacob.facemaker.RatioLocation;

/**
 * Created by Jacob on 2/6/2016.
 * This is the abstract class for Features. This is the foundation for all features and extends
 * drawable which gives each feature the ability to be drawn.
 */
public abstract class AbstractFeature extends Drawable {

    protected int color;
    protected RatioLocation location;

    public AbstractFeature(){}

    public AbstractFeature(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setLocation(RatioLocation location) {
        this.location = location;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return 1;
    }

}
