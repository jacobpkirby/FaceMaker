package com.example.jacob.facemaker.feature.eye;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

import com.example.jacob.facemaker.feature.AbstractFeature;
import com.example.jacob.facemaker.feature.Feature;

import java.util.Random;
/**
 * Created by jacob on 2/6/2016.
 * This class is used to make a type of eye. This type of eye is an oval shape.
 */


public class Eye extends AbstractFeature implements Feature {

    public Eye(){};
    // dx, dy define x-radius, y-radius
    private int dx;
    private int dy;

    //takes in the x and y radius of the eye
    public Eye(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void draw(Canvas c) {
        Paint paint = new Paint();
        paint.setColor(color);
        Path path = new Path();

        float x = location.x();
        float y = location.y();
        //creates the oval shape of the eye based off the radius selected
        path.addOval(x - dx, y + dy, x + dx, y - dy, Path.Direction.CW);

        c.drawPath(path, paint);
    }


}
