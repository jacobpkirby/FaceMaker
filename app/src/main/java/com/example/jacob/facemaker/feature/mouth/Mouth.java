package com.example.jacob.facemaker.feature.mouth;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import com.example.jacob.facemaker.feature.AbstractFeature;
import com.example.jacob.facemaker.feature.Feature;

/**
 * Created by Jacob on 2/6/2016.
 * This class is used to make the mouth for the face.
 */
public class Mouth extends AbstractFeature implements Feature {

    private static final float DX = 0.25f;
    private static final float DY = 0.125f;
    private static final int COLOR = Color.RED;

    public Mouth(int color) {
        this.color = color;
    }

    @Override
    public void draw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setColor(COLOR);

        Path path = new Path();

        float x = location.x();
        float y = location.y();
        path.addArc(x - (x * DX), y - (y * DY), x + (x * DX), y + (y * DY), 0.0f, 180.0f);

        canvas.drawPath(path, paint);
    }
}
