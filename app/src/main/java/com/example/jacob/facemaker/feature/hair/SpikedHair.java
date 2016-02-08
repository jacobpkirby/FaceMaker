package com.example.jacob.facemaker.feature.hair;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;

import com.example.jacob.facemaker.feature.AbstractFeature;
import com.example.jacob.facemaker.feature.Feature;

/**
 * Created by peter on 2/6/2016.
 * This class is used to make a type of hair. This type of hair is spiked.
 */
public class SpikedHair extends Hair implements Feature {

    public SpikedHair(){}

    public SpikedHair(int color) {
        this.color = color;
    }

    @Override
    public void draw(Canvas c) {

        System.out.println("---- Spikedhair.draw() ------");
        System.out.println(location.x() + " : " + location.y());
        System.out.println(color);


        Paint paint = new Paint();
        paint.setColor(color);
        Path path = new Path();

        paint.setStrokeWidth(4);
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);


        triangles(path);

        c.drawPath(path, paint);

    }

    private void triangles(Path ori) {

        int x = new Float(location.x()).intValue();
        int y = new Float(location.y()).intValue();

        int current = (int)(x - (0.4 * x));
        int max = (int)(x + (0.4 * x));
        int partitions = (max - current) / 8;

        while (current < max) {

            ori.addPath(buildTriangle(current, y, partitions));

            current += partitions;
        }

    }

    private Path buildTriangle(int x, int y, int size) {
        int left = x - (size/2);
        int right = x + (size/2);

        Point a = new Point(left, y);
        Point b = new Point(x, y - 150);
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
