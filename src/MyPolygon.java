/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vinuk
 */

/* ----------------------------------------------------------
Class MyPolygon inherited from the class the MyShape. The MyPolygons object
is a regular polygon defined by the integer parameter,
the number of the polygon is to equal side lengths and equal
interior angles, and the center (x, y) and radiusis r, of the
circle in which it is it is inscribed. MyPolygon object might
be filled with a color.
---------------------------------------------------------- */
/*
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class MyPolygon extends MyShape {
    private double radius;
    private int sides1;
    // Arrays for holding the points of the each corner on the polygon
    double xp[];
    double yp[];

    MyPolygon(double x, double y, double radius, int sides1, Color colors) {
        // here (x,y) is the center point
        super(x, y, colors);
        this.radius = radius;
        this.sides1 = sides1;
        xp = new double[sides1];
        yp = new double[sides1];
        // to Finds the correct position of the corner points on regular polygon
        double ang1 = (2 * Math.PI) / sides1;
        for (int i = 0; i < sides1; ++i) {
            xp[i] = x + (radius * (-1 * Math.sin(i * ang1)));
            yp[i] = y + (radius * (-1 * Math.cos(i * ang1)));
        }
    }

    public double getRadius() {
        return radius;
    }
    public double getArea() {
        return Math.pow(radius, 2) * sides1 * Math.sin(getAngle()) * 0.5;
    }
    public double getPerimeter() {
        return sides1 * getSide();
    }
    public double getApothem() {
        return radius * Math.cos(Math.toRadians(180 / sides1));
    }
    public double getDistance(double angle1) {
        angle1 = Math.toRadians(angle1);
        double x = radius * Math.cos(angle1) + super.getX();
        double y = radius * Math.sin(angle1) + super.getY();
        return Math.sqrt(Math.pow(x - super.getX(), 2) + Math.pow(y - super.getY(), 2));
    }
    public double getAngle() {
        return Math.PI / sides1;
    }
    public double getSide() {
        return 2 * radius * Math.sin(Math.PI / sides1);
    }

    @Override
    public String toString() {
        return String.format("----- The Polygon Properties -----\n%15s %.2f\n%15s %.2f\n%15s %.2f\n%15s %.2f\n%15s %.2f\n%15s " + super.getColor(),
            "Radius:", getRadius(), "Area:", getArea(), "Perimeter:", getPerimeter(),
            "Angle:", getAngle(), "Apothem:", getApothem(), "Color:");
    }
    @Override
    public MyRectangle getMyBoundingRectangle() {
        return new MyRectangle((super.getX() - radius), (super.getY() - radius),
            2 * radius, 2 * radius, super.getColor());
    }

    @Override
    public ArrayList < MyPoint > getMyArea() {
        final Color colors = super.getColor();
        // to ArrayList for holding set of all points in area
        ArrayList < MyPoint > sets = new ArrayList < > ();
        // the ArrayList for holding all the lines from origin to each point on the polygon sides
        ArrayList < MyLine > radialLines = new ArrayList < > ();
        // ArrayList for holding all sides
        ArrayList < MyLine > sideLines = new ArrayList < > ();
        for (int i = 1; i < sides1; ++i) {
            sideLines.add(new MyLine(xp[i - 1], yp[i - 1], xp[i], yp[i], colors));
        }
        sideLines.add(new MyLine(xp[sides1 - 1], yp[sides1 - 1], xp[0], yp[0], colors));
        // to Draws the line from the origin to each point on the sides. The summation of areas of each line would be the
        // area of polygon.
        for (int i = 0; i < sides1; ++i) {
            for (MyPoint point: sideLines.get(i).getMyArea()) {
                radialLines.add(new MyLine(super.getX(), super.getY(), point.getX(), point.getY(), colors));
            }
        }
        // Adds area of all lines into set as an approximation for area of polygon.
        for (MyLine radialLine: radialLines) {
            sets.addAll(radialLine.getMyArea());
        }
        return sets;
    }

    @Override
    public void draw(GraphicsContext gcs) {
        gcs.setFill(super.getColor());
        gcs.setStroke(super.getColor());
        gcs.setLineWidth(3);
        gcs.strokePolygon(xp, yp, sides1);
        gcs.fillPolygon(xp, yp, sides1);
    }
    public void border(GraphicsContext gcs) {
        gcs.setStroke(Color.BLACK);
        for (int i = 1; i < sides1; ++i) {
            gcs.strokeLine(xp[i - 1], yp[i - 1], xp[i], yp[i]);
        }
        gcs.strokeLine(xp[sides1 - 1], yp[sides1 - 1], xp[0], yp[0]);
    }
}
*/