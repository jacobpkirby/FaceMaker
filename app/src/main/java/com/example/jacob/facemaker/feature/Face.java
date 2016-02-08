package com.example.jacob.facemaker.feature;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;

import com.example.jacob.facemaker.RatioLocation;
import com.example.jacob.facemaker.feature.eye.Eyes;
import com.example.jacob.facemaker.feature.hair.Hair;
import com.example.jacob.facemaker.feature.hair.HairFactory;
import com.example.jacob.facemaker.feature.nose.Nose;
import com.example.jacob.facemaker.feature.nose.OvalNose;
import com.example.jacob.facemaker.feature.hair.SpikedHair;
import com.example.jacob.facemaker.feature.mouth.Mouth;
import com.example.jacob.facemaker.feature.head.Head;

import java.util.Random;

public class Face extends AbstractFeature implements Feature {

    private Eyes eyes;
    private Head head;
    private Mouth mouth;
    private Hair hair;
    private Nose nose;

    public Face() {
        eyes = new Eyes(Color.GREEN);
        head = new Head(Color.BLACK);
        mouth = new Mouth(Color.RED);
        nose = new  OvalNose(Color.BLUE);
        hair = new SpikedHair(Color.RED); // default hair
    }


    public void draw(Canvas c) {

        Rect rect = c.getClipBounds();




        head.draw(c);
        hair.setLocation(new RatioLocation(0f, -0.5f, rect));
        hair.draw(c);
        eyes.draw(c);

        nose.setLocation(new RatioLocation(0f, 0f, rect));
        nose.draw(c);

        mouth.setLocation(new RatioLocation(0f, 0.35f, rect));
        mouth.draw(c);


    }

    public Nose getNose() {
        return nose;
    }

    public void setNose(Nose nose) {
        this.nose = nose;
    }

    public Hair getHair() {
        return hair;
    }

    public void setHair(Hair hair) {
        this.hair = hair;
    }

    public Mouth getMouth() {
        return mouth;
    }

    public void setMouth(Mouth mouth) {
        this.mouth = mouth;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Eyes getEyes() {
        return eyes;
    }

    public void setEyes(Eyes eyes) {
        this.eyes = eyes;
    }
}
