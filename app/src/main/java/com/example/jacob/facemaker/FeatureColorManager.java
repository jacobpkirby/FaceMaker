package com.example.jacob.facemaker;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.jacob.facemaker.feature.Feature;

/**
 * Created by Jacob on 2/6/2016.
 * This class is used to manage all the colors for the face. The 3 color seek bars are defined in
 * this class. The textViews are also changed in this classes based off the progress of the seek
 * bars. The RadioButton is also defined in this class
 */

public class FeatureColorManager implements RadioGroup.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener{
    protected SeekBar redSeekBar = null;
    protected SeekBar blueSeekBar = null;
    protected SeekBar greenSeekBar = null;
    protected TextView redTextView = null;
    protected TextView blueTextView = null;
    protected TextView greenTextView = null;

    public static int redValue = 0;
    public static int blueValue = 0;
    public static int greenValue = 0;

    private Activity activity;
    private Doodle doodle;

    private Feature activeFeature;

    public FeatureColorManager(Activity activity, Doodle doodle) {
        this.activity = activity;
        this.doodle = doodle;
    }

    public void onCreate(Bundle savedInstanceState) {
        redSeekBar = (SeekBar) activity.findViewById(R.id.redSeekBar);
        redSeekBar.setOnSeekBarChangeListener(this);

        blueSeekBar = (SeekBar) activity.findViewById(R.id.blueSeekBar);
        blueSeekBar.setOnSeekBarChangeListener(this);

        greenSeekBar = (SeekBar) activity.findViewById(R.id.greenSeekBar);
        greenSeekBar.setOnSeekBarChangeListener(this);

        redTextView = (TextView) activity.findViewById(R.id.redTextView);
        blueTextView = (TextView) activity.findViewById(R.id.blueTextView);
        greenTextView = (TextView) activity.findViewById(R.id.greenTextView);
        redTextView.setText("Red:0");
        blueTextView.setText("Blue:0");
        greenTextView.setText("Green:0");
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(seekBar == this.redSeekBar){
            redTextView.setText("Red:"+progress);
            redValue = progress;
        }
        else if(seekBar == this.greenSeekBar){
            greenTextView.setText("Green:"+progress);
            greenValue = progress;
        }
        else if(seekBar == this.blueSeekBar){
            blueTextView.setText("Blue:"+progress);
            blueValue = progress;

        }
        int color = Color.argb(255, redSeekBar.getProgress(), greenSeekBar.getProgress(), blueSeekBar.getProgress());
        //you can also split that into the 3 channels if you wish
        //i'm assuming you actually want to show the resulting color
        //Face.setColor(color);


        activeFeature.setColor(color);
        doodle.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.HairRadioBtn) {
            activeFeature = doodle.getFace().getHair();
        } else if (checkedId == R.id.EyeRadioBtn) {
            activeFeature = doodle.getFace().getEyes();
        } else if (checkedId == R.id.SkinRadioBtn) {
            activeFeature = doodle.getFace().getHead();
        }

        Integer existingColor = activeFeature.getColor();
        int color = (int)Long.parseLong(Integer.toHexString(existingColor), 16);
        redValue = (color >> 16) & 0xFF;
        greenValue = (color >> 8) & 0xFF;
        blueValue = (color >> 0) & 0xFF;

        updateProgressValues();
    }

    private void updateProgressValues() {
        redSeekBar.setProgress(redValue);
        greenSeekBar.setProgress(greenValue);
        blueSeekBar.setProgress(blueValue);
    }


}
