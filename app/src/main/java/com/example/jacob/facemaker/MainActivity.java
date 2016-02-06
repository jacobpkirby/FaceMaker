package com.example.jacob.facemaker;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {
    protected SeekBar redSeekBar = null;
    protected SeekBar blueSeekBar = null;
    protected SeekBar greenSeekBar = null;
    protected TextView redTextView = null;
    protected TextView blueTextView = null;
    protected TextView greenTextView = null;
    public static int redValue = 0;
    public static int blueValue = 0;
    public static int greenValue = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redSeekBar = (SeekBar) findViewById(R.id.redSeekBar);
        redSeekBar.setOnSeekBarChangeListener(this);

        blueSeekBar = (SeekBar) findViewById(R.id.blueSeekBar);
        blueSeekBar.setOnSeekBarChangeListener(this);

        greenSeekBar = (SeekBar) findViewById(R.id.greenSeekBar);
        greenSeekBar.setOnSeekBarChangeListener(this);

        redTextView = (TextView) findViewById(R.id.redTextView);
        blueTextView = (TextView) findViewById(R.id.blueTextView);
        greenTextView = (TextView) findViewById(R.id.greenTextView);
        redTextView.setText("Red:0");
        blueTextView.setText("Blue:0");
        greenTextView.setText("Green:0");
    }

    @Override
    public void onClick(View v){



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
        //face.setColor(color);
        Doodle.setColor(color);


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
