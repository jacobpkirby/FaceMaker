package com.example.jacob.facemaker;

import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by Jacob on 2/6/2016.
 * This class is used to calculate the ratios needed to align each
 * feature correctly on the face and on the surface view.
 */
public class RatioLocation {

    private float initX;
    private float initY;
    private float dx; // percentage between -1.0 - +1.0
    private float dy; // percentage between -1.0 - +1.0

    /**

     * @param dx a percent to shift left or rigt, values between -1.0 - +1.0
     * @param dy a percent to shift up and down, values between -1.0 - +1.0
     * @param rect a rectangle, whose center will be used as a fixed point from which
     *             to shift this location according to the dx dy parameters.
     *
     * For example, specifying dx = 0.5, would mean that this location represents a
     * point shift right from the center of rect by 50% of the width of rect.
     */
        public RatioLocation(float dx, float dy, Rect rect) {
        this.initX = rect.width() / 2.0f; // finds the middle
        this.initY = rect.height() / 2.0f; // finds the middle
        this.dx = dx;
        this.dy = dy;
    }

    //this method returns the x coordinate adjusted by the percent given by dx.
    public float x() {
        return initX + (initX * dx);
    }
    //this method returns the y coordinate adjusted by the percent given by dy.
    public float y() {
        return initY + (initY * dy);
    }

    /*
    The next 4 methods are used to find ratios needed to make a oval path. With these calculations
    it is easier to plot the location of each feature.
    */
    public float left(float percent) {
        return x() + (x() * (-1.0f * percent));
    }
    public float right(float percent){
        return x() + (x() * percent);
    }

    public float top(float percent){
        return y() + (y() * (-1.0f * percent));
    }

    public float bottom(float percent){
        return y() + (y() *  percent);
    }

}
