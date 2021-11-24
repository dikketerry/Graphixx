package io.eholland.shapes;

import io.eholland.DrawingContext;
import io.eholland.exception.NegativeNumberException;

public class Shape_Oval extends Shape {

    // variables
    public static final int ANGLES = 0;
    private static int count;
    private int majorRadius;
    private int minorRadius;

    // initialisation block
    {
        count++;
    }

    // constructors
    public Shape_Oval() {
        this(0, 0);
    }

    public Shape_Oval(int majorRadius, int minorRadius) {
        this(majorRadius, minorRadius, 0, 0);
    }

    public Shape_Oval(int majorRadius, int minorRadius, int x, int y) {
        super(x, y);
        setMajorRadius(majorRadius);
        setMinorRadius(minorRadius);
    }

    public Shape_Oval(Shape_Oval oval) {
        this(oval.getMajorRadius(), oval.getMinorRadius(), oval.getX(), oval.getY());
    }

    //methods
    public int getMajorRadius() {
        return majorRadius;
    }

    public void setMajorRadius(int majorRadius) throws RuntimeException {
        if (majorRadius < 0) {
            throw new NegativeNumberException("negative majorRadius oval " +
                    "shape");
        }
        this.majorRadius = majorRadius;
    }

    public int getMinorRadius() {
        return minorRadius;
    }

    public void setMinorRadius(int minorRadius) throws RuntimeException {
        if (minorRadius < 0) {
            throw new NegativeNumberException("negative minorRadius oval " +
                    "shape");
        }
        this.minorRadius = minorRadius;
    }

    @Override
    public float getArea() {
        return (float) (majorRadius * minorRadius * Math.PI);
    }

    @Override
    public float getPerimeter() { // approximate
        return (float) (2 * Math.PI * (Math.sqrt(Math.pow(majorRadius, 2) + Math.pow(minorRadius,
                                                                 2)) / 2));
    }

    @Override
    public boolean equals(Object o) {
        if ((o != null) && (getClass() == o.getClass()) && (((Shape_Oval) o).getX() == getX()) && (((Shape_Oval) o).getY() == getY()) && (((Shape_Oval) o).getMajorRadius() == getMajorRadius())) {
            return true;
        } else return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() * (majorRadius / minorRadius);
    }

    @Override
    public String toString() {
        return String.format("A circle with radius %d, area %f and perimeter " +
                                     "%f", majorRadius, getArea(), getPerimeter());
    }

    @Override
    public void scale(float factor) {
        setMajorRadius((int) (getMajorRadius() * factor) / 100);
    }

    @Override
    public void draw(DrawingContext dc) {
        dc.draw(this);
    }

    public static int getCount() {
        return count;
    }

}
