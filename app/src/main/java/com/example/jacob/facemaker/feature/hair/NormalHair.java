package com.example.jacob.facemaker.feature.hair;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;

import com.example.jacob.facemaker.feature.AbstractFeature;
import com.example.jacob.facemaker.feature.Feature;

/**
 * Created by Jacob on 2/6/2016.
 * This class is used to make a type of hair. This type of hair is normal, meduim length.
 */
public class NormalHair extends Hair implements Feature {

    //This class creates the Normal hair style path
    @Override
    public void draw(Canvas c) {

        Paint paint = new Paint();
        paint.setColor(color);
        Path path = new Path();

        path.addArc(
                location.left(0.5f),
                location.top(0.5f),
                location.right(0.5f),
                location.bottom(0.7f),
                180f, 180f);

        c.drawPath(path, paint);

    }



}
