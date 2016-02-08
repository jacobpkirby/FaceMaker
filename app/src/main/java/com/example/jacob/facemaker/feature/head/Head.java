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

        Rect rect = canvas.getClipBounds();

        float x = rect.width() / 2.0f;
        float y = rect.height() / 2.0f;

        float dx =  x * WIDTH_RATIO;
        float dy = y * HEIGHT_RATIO;


        path.addOval(x - dx, y - dy, x + dx, y + dy, Path.Direction.CCW);

        canvas.drawPath(path, paint);
    }

}
