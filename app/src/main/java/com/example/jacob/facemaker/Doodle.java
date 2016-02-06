
package com.example.jacob.facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * Created by Jacob on 2/1/2016.
 */
public class Doodle extends SurfaceView {
    static int rectColor;

    public Doodle(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public Doodle(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
    }

    public Doodle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setWillNotDraw(false);
    }

    public Doodle(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setWillNotDraw(false);
    }

    public static void setColor(int color) {
        Doodle.rectColor = color;
    }


    @Override
    public void onDraw(Canvas canvas){
        Paint magentaPaint = new Paint();

        magentaPaint.setColor(Color.MAGENTA);
        canvas.drawRect(50.0f,50.0f,100.0f,100.0f,magentaPaint);




    }
}

