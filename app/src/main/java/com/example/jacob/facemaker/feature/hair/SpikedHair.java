package com.example.jacob.facemaker.feature.hair;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;

import com.example.jacob.facemaker.feature.AbstractFeature;
import com.example.jacob.facemaker.feature.Feature;

/**
 * Created by Jacob on 2/6/2016.
 * This class is used to make a type of hair. This type of hair is spiked.
 */
public class SpikedHair extends Hair implements Feature {

    //this class has 2 constructors.
    public SpikedHair(){}

    public SpikedHair(int color) {
        this.color = color;
    }

    @Override
    public void draw(Canvas c) {

        Paint paint = new Paint();
        paint.setColor(color);
        Path path = new Path();

        //Sets path features so that it will correctly draw a path
        paint.setStrokeWidth(4);
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);


        triangles(path);

        c.drawPath(path, paint);

    }

    /*
    This function is used to make the triangles needed for the spiked hair
     */
    private void triangles(Path ori) {
        //ints x and y are set for the center of the surface view
        int x = new Float(location.x()).intValue();
        int y = new Float(location.y()).intValue();


        int current = (int)(x - (0.4 * x)); //used to find what triangle is currently being made
        int max = (int)(x + (0.4 * x)); // this is the farthest distance a traingle can be made
        int partitions = (max - current) / 8;// is the size of each triangle so that 8 will be made

        //this loop is to draw each traingle in its appropriate location till current triangle
        //hits the max location
        while (current < max) {
        // calls the function buildTraingle which makes the path then adds it to the overall design
            ori.addPath(buildTriangle(current, y, partitions));

            current = current +  partitions;
        }

    }
    /*
    This method is used to build triangle paths
     */
    private Path buildTriangle(int x, int y, int size) {
        // left and right repersent each edge of the base of the triangle.
        int left = x - (size/2);
        int right = x + (size/2);

        //the points of triangle are made
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
