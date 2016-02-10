package com.example.jacob.facemaker.feature.head;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;

import com.example.jacob.facemaker.feature.AbstractFeature;
import com.example.jacob.facemaker.feature.Feature;

/**
 * Created by Jacob on 2/6/2016.
 * This class is used to make the head for the app.
 */
public class Head extends AbstractFeature implements Feature {

    //These falues are used to position the head oval onto the surface view.
    private static final float WIDTH_RATIO = 0.70f;
    private static final float HEIGHT_RATIO = 0.65f;

    public Head(int color) {

        this.color = color;
    }

    @Override
    public void draw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setColor(color);

        Path path = new Path();

        Rect rect = canvas.getClipBounds(); // rect is the size of the surface view

        float x = rect.width() / 2.0f; // x is centered
        float y = rect.height() / 2.0f;  // y is centered

        float dx =  x * WIDTH_RATIO; // the radius in the x direction with respect to the ratio
        float dy = y * HEIGHT_RATIO; // the radius in the y direction with

    // creates the face path
        path.addOval(x - dx, y - dy, x + dx, y + dy, Path.Direction.CCW);

        canvas.drawPath(path, paint);
    }

}
