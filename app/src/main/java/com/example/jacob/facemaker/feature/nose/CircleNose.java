package com.example.jacob.facemaker.feature.nose;

/**
 * Created by Jacob on 2/7/2016.
 *
 * This class makes a circle nose
 */

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;


import com.example.jacob.facemaker.feature.Feature;

public class CircleNose extends Nose implements Feature {

    // These variables sets the DX DY ratio to zero which result in no change to the radius
    private static final float DX = 0f;
    private static final float DY = 0f;

    public CircleNose() {};

    public CircleNose(int color)
    {
        this.color = color;
    }

    @Override
    public void draw(Canvas c) {
        Paint paint = new Paint();
        paint.setColor(color);
        Path path = new Path();

        //creates the  path for the circle nose which makes it center with radius 50
        path.addCircle(
                location.left(DX),location.top(DY),50.0f,
                Path.Direction.CW);

        c.drawPath(path, paint);
    }
}