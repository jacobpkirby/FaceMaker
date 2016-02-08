package com.example.jacob.facemaker.feature.eye;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import com.example.jacob.facemaker.feature.AbstractFeature;
import com.example.jacob.facemaker.feature.Feature;

import java.util.Random;
/**
 * Created by jacob on 2/6/2016.
 * This class is used to make a type of eye. This type of eye is an oval shape.
 */


public class NormalEye extends Eye implements Feature {

    public NormalEye(){};
    // dx, dy define x-radius, y-radius
    private int dx;
    private int dy;


    public NormalEye(int dx, int dy, int color) {
        this.dx = dx;
        this.dy = dy;
        this.color = color;
    }

    @Override
    public void draw(Canvas c) {
        Paint paint = new Paint();
        paint.setColor(color);
        Path path = new Path();

        float x = location.x();
        float y = location.y();

        path.addOval(x - dx, y + dy, x + dx, y - dy, Path.Direction.CW);

        c.drawPath(path, paint);
    }

    public void randomShape() {
        Random r = new Random();
        this.dx = r.nextInt(50) + 50;
    }

    public void randomColor() {

    }


}
