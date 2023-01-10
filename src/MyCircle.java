/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vinuk
 */

/* ----------------------------------------------------------
Class MyCircle inherits from class MyShape. The MyCircle object
is defined by its center (x, y) and radius the r, and may be get
filled with any color.
---------------------------------------------------------- */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class MyCircle extends MyOval {
    private double radius;

    MyCircle(double x, double y, double radius, Color colors) {
        super(x, y, radius * 2, radius * 2, colors);
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    public double getRadius() {
        return radius;
    }


    //Override method
    @Override
    public String toString() {
        return String.format("----- The Circle Properties -----\n%15s (%.2f,%.2f)\n%15s %.2f\n%15s %.2f\n%15s %.2f\n%15s " + super.getColor(),
            "Center:", super.getX(), super.getY(), "Radius:", getRadius(), "Area:", getArea(), "Perimeter:", getPerimeter(), "Colors:");
    }

    //overide method
    @Override
    public MyRectangle getMyBoundingRectangle() {
        return new MyRectangle((int)(super.getX() - radius), (int)(super.getY() - radius),
            2 * radius, 2 * radius, super.getColor());
    }

    //overide method
    @Override
    public ArrayList < MyPoint > getMyArea() {
        ArrayList < MyPoint > sets = new ArrayList < > ();
        // here we Uses circle equation to determine whether the point is in region and adds the point to set whether it is true
        for (double x = (getX() - radius); x <= radius * 2 + getX(); x++) {
            for (double y = (getY() - radius); y <= radius * 2 + getY(); y++) {
                double dx = x - getX();
                double dy = y - getY();
                double distanceSquareds = Math.pow(dx, 2) + Math.pow(dy, 2);
                if (distanceSquareds <= Math.pow(radius, 2)) sets.add(new MyPoint(x, y));
            }
        }
        return sets;
    }

    @Override
    public void draw(GraphicsContext gcs) {
        gcs.setFill(super.getColor());
        gcs.setStroke(super.getColor());
        gcs.strokeOval(super.getX() - radius, super.getY() - radius, 2 * radius, 2 * radius);
        gcs.fillOval(super.getX() - radius, super.getY() - radius, 2 * radius, 2 * radius);
    }
}
