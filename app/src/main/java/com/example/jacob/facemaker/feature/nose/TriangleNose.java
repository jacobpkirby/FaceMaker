package com.example.jacob.facemaker.feature.nose;

/**
 * Created by Jacob on 2/7/2016.
 */

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;

import com.example.jacob.facemaker.feature.AbstractFeature;
import com.example.jacob.facemaker.feature.Feature;

public class TriangleNose extends Nose implements Feature {

    private static final float DX = 0.15f;
    private static final float DY = 0.15f;

    public TriangleNose(){};
    public TriangleNose(int color) {
        this.color = color;
    }
    @Override
    public void draw(Canvas canvas) {


        Paint paint = new Paint();
        paint.setColor(color);


        paint.setStrokeWidth(20);
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);

        Rect rect = canvas.getClipBounds();
        int X = (int) (rect.width() / 2.0f);
        int Y = (int) (rect.height() / 2.0f);

        Point a = new Point(X-30,Y);
        Point b = new Point(X+30,Y);
        Point c = new Point(X,Y+60) ;

        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(a.x, a.y);
        path.lineTo(b.x, b.y);
        path.moveTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.moveTo(c.x, c.y);
        path.lineTo(a.x, a.y);
        path.close();

        canvas.drawPath(path, paint);
    }

    private Path buildTriangle(int x, int y, int size) {
        int left = x - (size/2);
        int right = x + (size/2);

        Point a = new Point(left, y);
        Point b = new Point(x, y - 50);
        Point c = new Point(right, y);

        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);

        path.moveTo(x, y);
        path.lineTo(a.x, a.y);
        path.lineTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.close();

        return path;
    }



}