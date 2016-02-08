package com.example.jacob.facemaker.feature.nose;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

import com.example.jacob.facemaker.feature.AbstractFeature;
import com.example.jacob.facemaker.feature.Feature;
import com.example.jacob.facemaker.feature.hair.Hair;

/**
 * Created by peter on 2/6/2016.
 */
public class OvalNose extends Nose implements Feature {


    private static final float DX = 0.1f;
    private static final float DY = 0.1f;

    public OvalNose(){};
    public OvalNose(int color) {
        this.color = color;
    }

    @Override
    public void draw(Canvas c) {
        Paint paint = new Paint();
        paint.setColor(color);
        Path path = new Path();



        path.addOval(
                location.left(DX),
                location.top(DY),
                location.right(DX),
                location.bottom(DY),
                Path.Direction.CW);

        c.drawPath(path, paint);
    }

}
