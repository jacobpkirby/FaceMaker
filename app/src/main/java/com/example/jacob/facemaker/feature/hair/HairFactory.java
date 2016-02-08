package com.example.jacob.facemaker.feature.hair;

/**
 * Created by jacob on 2/6/2016.
 * This is where the hair is selected. Each hair possibility is shown here and is made if
 * the name is selected from the spinner.
 */
public class HairFactory {

    public static final String SPIKED = "Spiked";
    public static final String NORMAL = "Normal";
    public static final String SHORT = "Short";
    public static final String[] STYLES = {
        "Spiked", "Normal","Short"
    };

    public static Hair getInstance(String name) {

        if (name.equals(SPIKED)) {
            return new SpikedHair();
        } else if (name.equals(NORMAL)) {
            return new NormalHair();
        } else if (name.equals(SHORT)){
            return new ShortHair();
        }  else {
            throw new IllegalArgumentException("Invalid hair style name: " + name);
        }

    }

}
