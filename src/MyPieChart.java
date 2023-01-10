/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vinuk
 */

import javafx.scene.canvas.GraphicsContext;
import java.util.HashMap;
import java.util.Map;

public class MyPieChart {
    private final double centerXs, centerYs, RADIUS;
    private final int EVENTS, TOTALs;
    private HashMap < Character, Integer > frequencys;
    public MyPieChart(double x, double y, double radius, int events, HashMap < Character, Integer > frequencys) {
        centerXs = x;
        centerYs = y;
        RADIUS = radius;
        EVENTS = events;
        this.frequencys = frequencys;
        int temps = 0;
        for (int i: frequencys.values()) temps += i;
        TOTALs = temps;
    }

    public void draw(GraphicsContext gcs) {
        double degrees = 0, remainingLetters = TOTALs, shift, max, textX, textY, probability, radius, midAngles;
        Slice slice = new Slice(centerXs - RADIUS, centerYs - RADIUS, RADIUS * 2, RADIUS * 2, MyColor.LIGHTGREY.getCol());
        slice.draw(gcs);
        MyArc partition;
        for (int i = 0; i < EVENTS; ++i) {
            max = 0;
            Character c1 = 'A';
            for (Map.Entry < Character, Integer > k: frequencys.entrySet()) {
                if (k.getValue() > max) {
                    max = k.getValue();
                    c1 = k.getKey();
                }
            }
            if (c1 != 'A') frequencys.remove(c1);
            probability = max / TOTALs;
            remainingLetters -= max;
            shift = 360 * probability;
            midAngles = degrees + shift / 2;
            radius = slice.getRadius(midAngles);
            partition = new MyArc(degrees, shift, slice, MyColor.getRandom());
            partition.draw(gcs);
            System.out.println(partition + "\n\n");
            textX = (radius * 11 / 10) * Math.cos(Math.toRadians(midAngles));
            textY = (radius * 11 / 10) * Math.sin(Math.toRadians(midAngles));
            if (midAngles > 100 && midAngles < 260) {
                textX -= radius / 6;
            }
            degrees += shift;
            gcs.setFill(MyColor.BLACK.getCol());
            gcs.fillText((String.format("%c, %.4f", c1, probability)), centerXs + textX, centerYs - textY);
            if (i + 1 == EVENTS) {
                midAngles = (360 - degrees) / 2;
                radius = slice.getRadius(midAngles);
                textX = (radius * 11 / 10) * Math.cos(Math.toRadians(midAngles));
                textY = (radius * 11 / 10) * Math.sin(Math.toRadians(midAngles));
                if (midAngles > 100 && midAngles < 260) {
                    textX -= radius - radius * Math.abs((180 - midAngles) / 180);
                }
                gcs.fillText((String.format("All other letters, %.4f", remainingLetters / TOTALs)), centerXs + textX, centerYs + textY);
                //System.out.println(partition + "\n\n");
                break;
            }
        }
    }
}
