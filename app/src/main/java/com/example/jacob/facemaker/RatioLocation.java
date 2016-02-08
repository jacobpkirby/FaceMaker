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

    public RatioLocation(float dx, float dy, Rect rect) {
        this.initX = rect.width() / 2.0f;
        this.initY = rect.height() / 2.0f;
        this.dx = dx;
        this.dy = dy;
    }

    public float x() {
        return initX + (initX * dx);
    }

    public float y() {
        return initY + (initY * dy);
    }

    public float left(float percent) {
        return x() + (x() * (-1.0f * percent));
    }

    public float right(float percent) {
        return x() + (x() * percent);
    }

    public float top(float percent) {return y() + (y() * (-1.0f * percent));
    }

    public float bottom(float percent) {return y() + (y() *  percent);
    }

}
