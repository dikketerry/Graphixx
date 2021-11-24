package io.eholland.shapes;

import io.eholland.DrawingContext;
import io.eholland.exception.NegativeNumberException;

public class Shape_Circle extends Shape_Oval {

    // variables
    private static int count;

    // initialisation block
    {
        count++;
    }

    // constructors
    public Shape_Circle() {
        this(0);
    }

    public Shape_Circle(int radius) {
        this(radius, 0, 0);
    }

    public Shape_Circle(int radius, int x, int y) {
        super(radius, radius, x, y);
    }

    public Shape_Circle(Shape_Circle circle) {
        this(circle.getRadius(), circle.getX(), circle.getY());
    }

    //methods
    public int getRadius() {
        return getMajorRadius();
    }

    public void setRadius(int radius) throws RuntimeException {
        if (radius < 0) {
            throw new NegativeNumberException("negative radius circle");
        }
        super.setMajorRadius(radius);
        super.setMinorRadius(radius);
    }

    @Override
    public float getArea() {
        return (float) (Math.pow(this.getRadius(), 2) * Math.PI);
    }

    @Override
    public float getPerimeter() {
        return (float) (2 * this.getRadius() * Math.PI);
    }

    @Override
    public boolean equals(Object o) {
        if ((o != null) && (getClass() == o.getClass()) && (((Shape_Circle) o).getX() == getX()) && (((Shape_Circle) o).getY() == getY()) && (((Shape_Circle) o).getRadius() == getRadius())) {
            return true;
        } else return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() * this.getRadius();
    }

    @Override
    public String toString() {
        return String.format("A circle with radius %d, area %f and perimeter " +
                                     "%f", getRadius(), getArea(), getPerimeter());
    }

    @Override
    public void scale(float factor) {
        setRadius((int) (getRadius() * factor) / 100);
    }

    @Override
    public void draw(DrawingContext dc) {
        dc.draw(this);
    }

    public static int getCount() {
        return count;
    }
}
