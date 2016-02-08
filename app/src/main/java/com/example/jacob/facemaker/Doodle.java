
package com.example.jacob.facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceView;

import com.example.jacob.facemaker.feature.Face;

/**
 * Created by Jacob on 2/1/2016.
 * This is the surface View class. This is where the face is drawn onto the surface View.
 */
public class Doodle extends SurfaceView {
    private Face face = new Face();



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

    public void setColor(int rectColor) {
       // this.rectColor = rectColor;
        invalidate();
    }


    @Override
    public void onDraw(Canvas canvas){
        face.draw(canvas);
    }

    public Face getFace() {
        return face;
    }
}

