package com.example.jacob.facemaker.feature.nose;

/**
 * Created by Jacob on 2/7/2016.
 */

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

import com.example.jacob.facemaker.feature.AbstractFeature;
import com.example.jacob.facemaker.feature.Feature;

public class CircleNose extends Nose implements Feature {


    private static final float DX = 0f;
    private static final float DY = 0f;

    public CircleNose() {};

    public CircleNose(int color) {
        this.color = color;
    }

    @Override
    public void draw(Canvas c) {
        Paint paint = new Paint();
        paint.setColor(color);
        Path path = new Path();

        path.addCircle(
                location.left(DX),location.top(DY),50.0f,
                Path.Direction.CW);

        c.drawPath(path, paint);
    }
}