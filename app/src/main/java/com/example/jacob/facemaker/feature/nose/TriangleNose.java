package com.example.jacob.facemaker.feature.nose;

/**
 * Created by Jacob on 2/7/2016.
 * This class is used to make the triangle nose
 */

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;

import com.example.jacob.facemaker.feature.AbstractFeature;
import com.example.jacob.facemaker.feature.Feature;

public class TriangleNose extends Nose implements Feature {


    public TriangleNose(){};
    public TriangleNose(int color) {

        this.color = color;
    }
    @Override
    public void draw(Canvas canvas) {


        Paint paint = new Paint();
        paint.setColor(color);

        //sets the correct type of width and paint style needed
        paint.setStrokeWidth(20);
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);

        //rect is the surface view size;
        Rect rect = canvas.getClipBounds();
        int X = (int) (rect.width() / 2.0f); // x is the middle of surface view
        int Y = (int) (rect.height() / 2.0f);//y is the middle of surface view

        /**
         External Citation
         Date: 2 September 2016
         Problem: Could not find how to build a triangle path
         Resource:
         http://stackoverflow.com/questions/3501126/how-to-draw-a-filled-triangle-in-android-canvas
         Solution: I used the example code from this post.
         */


        // threee points are made which are used to create path
        Point a = new Point(X-30,Y);
        Point b = new Point(X+30,Y);
        Point c = new Point(X,Y+60) ;


        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(a.x, a.y);
        path.lineTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.lineTo(a.x, a.y);
        path.close();

        canvas.drawPath(path, paint);
    }



}