package com.example.jacob.facemaker.feature.nose;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

import com.example.jacob.facemaker.feature.AbstractFeature;
import com.example.jacob.facemaker.feature.Feature;
import com.example.jacob.facemaker.feature.hair.Hair;

/**
 * Created by jacob on 2/6/2016.
 * This class is used to make the oval nose style
 */
public class OvalNose extends Nose implements Feature {

    //These floats are used to position the nose with the correct ratio
    private static final float DX = 0.1f;
    private static final float DY = 0.1f;

    public OvalNose(){};
    public OvalNose(int color)
    {
        this.color = color;
    }

    @Override
    public void draw(Canvas c) {
        Paint paint = new Paint();
        paint.setColor(color);
        Path path = new Path();


        // the oval nose is created by using the ratio and sending that to the ratioLocation to
        //be properly located on  the surface view
        path.addOval(location.left(DX), location.top(DY), location.right(DX), location.bottom(DY),
                Path.Direction.CW);

        c.drawPath(path, paint);
    }

}
