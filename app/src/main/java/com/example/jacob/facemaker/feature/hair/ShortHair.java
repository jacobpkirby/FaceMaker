package com.example.jacob.facemaker.feature.hair;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

import com.example.jacob.facemaker.feature.Feature;

/**
 * Created by Jacob on 2/7/2016.
 * This class is used to make a type of hair. This type of hair is short.
 */
public class ShortHair extends Hair implements Feature {

// this method creats the short hair style
    @Override
    public void draw(Canvas c) {

        Paint paint = new Paint();
        paint.setColor(color);
        Path path = new Path();

        path.addArc(
                location.left(0.4f),
                location.top(0.3f),
                location.right(0.4f),
                location.bottom(0.2f),
                180f, 180f);

        c.drawPath(path, paint);

    }
}
