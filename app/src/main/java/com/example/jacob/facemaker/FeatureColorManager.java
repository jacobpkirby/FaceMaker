package com.example.jacob.facemaker;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.jacob.facemaker.feature.Feature;

/**
 * Created by Jacob on 2/6/2016.
 * This class is used to manage all the colors for the face. The 3 color seek bars are defined in
 * this class. The textViews are also changed in this classes based off the progress of the seek
 * bars. The RadioButton is defined in this class. I felt like this was the best structure to keep
 * everything organized rather then having it all in one class.
 */

public class FeatureColorManager implements RadioGroup.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener{
    //The seekbars are created along with the textViews
    protected SeekBar redSeekBar = null;
    protected SeekBar blueSeekBar = null;
    protected SeekBar greenSeekBar = null;
    protected TextView redTextView = null;
    protected TextView blueTextView = null;
    protected TextView greenTextView = null;
    //these variables are created to get the
    public int redValue = 0;
    public int blueValue = 0;
    public int greenValue = 0;

    protected int color; //integer used to get the number for the color created by the seek bars

    //creates an activity
    private Activity activity;
    //creates the surface View
    private Doodle doodle;

    //This int is used to keep track of what radio button has been pushed.
    private int activeFeatureId = 0;

    //constructor of the class. Each FeatureColorManager must have a activity and surface View
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
        //When seekbars are changed, there corresponding TextViews will change numbers
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
        // gets the int of what colors the seekbars have created
        color = Color.argb(255, redSeekBar.getProgress(), greenSeekBar.getProgress(), blueSeekBar.getProgress());

        //set the active feature to the color selected
        getActiveFeature().setColor(color);


        doodle.invalidate(); // tells the surface view to refresh
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //not used
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //not used
    }

    /*
    getActiveFeature finds out what radio button has been selected and then returns the feature
    associated with it.
         */
    private Feature getActiveFeature() {
        switch(activeFeatureId) {
            case R.id.EyeRadioBtn:
                return doodle.getFace().getEyes();
            case R.id.HairRadioBtn:
                return doodle.getFace().getHair();
            case R.id.SkinRadioBtn:
                return doodle.getFace().getHead();
            default:
                throw new IllegalArgumentException("invalid feature id");
        }
    }


     /*
     This method finds what Radio button is selected. It also finds the color of the existing
       feature and updates the values of the color ints so that the seek bars will correcly
       resemble the numbers associated with the feature selected.
      */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        activeFeatureId = checkedId;

        //gets the existing Color by finding the ActiveFeature then getting that color.
        Integer existingColor = getActiveFeature().getColor();
        //Converts the color into its color componants.
        int color = (int)Long.parseLong(Integer.toHexString(existingColor), 16);
        redValue = (color >> 16) & 0xFF;
        greenValue = (color >> 8) & 0xFF;
        blueValue = (color >> 0) & 0xFF;

        updateProgressValues();
    }
    /*
    this method updates the seeks bars with the new color of the selected feature from the radio
    button. This makes sure that whenever a radio button is pushed the seek bars will be up to date
     */
    private void updateProgressValues() {
        redSeekBar.setProgress(redValue);
        greenSeekBar.setProgress(greenValue);
        blueSeekBar.setProgress(blueValue);
    }
    /*
    This method sets the activeFeature to whatever feature is selected on the Radio Button
     */
    public void setActiveFeatureId(int featureId) {
       this.activeFeatureId = featureId;
    }

}
