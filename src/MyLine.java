/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vinuk
 */

/* ----------------------------------------------------------
The Class MyLine inherits from class MyShape. The MyLine object is a
object which is straight line defined by the endpoints (x1, y1)& (x2, y2).
The MyLine object may be of any color.
---------------------------------------------------------- */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class MyLine extends MyShape {
    private final double x1, y1, x2, y2; // the Coordinates of two points of the line

    MyLine(double x1, double y1, double x2, double y2, Color colors) {
        super(0, 0, colors);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getLength() {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    public static double getLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    public double get_xAngle() {
        double angles = Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));
        if (angles < 0) {
            angles += 360;
        }
        return angles;
    }

    //overide method
    @Override
    public String toString() {
        return String.format("-----The Line Properties -----\n%15s (%.2f,%.2f)\n%15s (%.2f,%.2f)\n%15s %.2f\n%15s %.2f\n%15s " + super.getColor(),
            "Point 1:", x1, y1, "Point 2:", x2, y2, "Line Length:", getLength(), "Angle:", get_xAngle(), "Color:");
    }

    @Override
    public MyRectangle getMyBoundingRectangle() {
        double cornerXs, cornerYs;
        cornerXs = Math.min(x1, x2);
        cornerYs = Math.min(y1, y2);
        return new MyRectangle(cornerXs, cornerYs, Math.abs(x2 - x1), Math.abs(y2 - y1), super.getColor());
    }

    @Override
    public ArrayList < MyPoint > getMyArea() {
        ArrayList < MyPoint > sets = new ArrayList < > ();
        double m1 = (y2 - y1) / (x2 - x1), intersects = y1 - (m1 * x1);
        MyRectangle bounds = getMyBoundingRectangle();
        double lens = getLength(), bX = bounds.getX(), bY = bounds.getY();

        for (double x = bX; x <= bX + bounds.getWidth(); ++x)
            for (double y = bY; y <= bY + bounds.getHeight(); ++y)
                if (Math.abs(y - (m1 * x + intersects)) < 1)
                    sets.add(new MyPoint(x, y));
        if (Math.abs(get_xAngle() - 90) < 1) {
            for (int i = 0; i < lens; ++i) sets.add(new MyPoint(x1, y1 + i));
        } else if (Math.abs(get_xAngle() - 270) < 1) {
            for (int i = 0; i < lens; ++i) sets.add(new MyPoint(x1, y1 - i));
        }
        return sets;
    }

    @Override
    public void draw(GraphicsContext gcs) {
        gcs.setStroke(super.getColor());
        gcs.strokeLine(x1, y1, x2, y2);
    }
}
