/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vinuk
 */

/* ----------------------------------------------------------
Class MyPoint is used by the class MyShape to defined the
reference points p(x, y) of the Java to display the coordinate
system.
---------------------------------------------------------- */

import javafx.scene.canvas.GraphicsContext;

public class MyPoint {
    private double x;
    private double y;

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("-----The Point Properties -----\n%15s (%.2f,%.2f)", "Point:", x, y);
    }

    public void draw(GraphicsContext gcs) {
        gcs.setFill(MyColor.BLACK.getCol());
        gcs.fillOval(x, y, 1, 1);
    }
}
