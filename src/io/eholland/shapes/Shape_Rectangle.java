package io.eholland.shapes;

import io.eholland.DrawingContext;
import io.eholland.exception.NegativeNumberException;

import javax.management.RuntimeErrorException;

public class Shape_Rectangle extends Shape {

    // variables
    private static int count;
    public static final int ANGLES = 4;
    private int width;
    private int height;

    // initialisation block
    {
        count++;
    }

    // constructors
    public Shape_Rectangle() {
        this(0, 0);
    }

    public Shape_Rectangle(int height, int width) {
        this(height, width, 0, 0);
    }

    public Shape_Rectangle(int height, int width, int x, int y) {
        setWidth(width);
        setHeight(height);
        super.setPosition(x, y);
    }

    public Shape_Rectangle(Shape_Rectangle rectangle) {
        this(rectangle.getWidth(), rectangle.getHeight(), rectangle.getX(), rectangle.getY());
    }

    // methods
    public void setWidth(int width) throws RuntimeErrorException {
        if (width < 0) throw new NegativeNumberException("negative width " +
                "rectangle");
        this.width = width;
    }

    public void setHeight(int height) throws RuntimeErrorException {
        if (height < 0) throw new NegativeNumberException("negative height " +
                "rectangle");
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static int getCount() {
        return count;
    }

    // overrides
    @Override
    public void draw(DrawingContext dc) {
        dc.draw(this);
    }

    @Override
    public void scale(float factor) {
        setHeight((int) (getHeight() * factor) / 100);
        setWidth((int) (getWidth() * factor) / 100);
    }

    @Override
    public float getArea() {
        return height * width;
    }

    @Override
    public float getPerimeter() {
        return (height * 2) + (width * 2);
    }

    @Override
    public boolean equals(Object o) {
        if ((o != null) && (getClass() == o.getClass()) && (((Shape_Rectangle) o).getX() == getX()) && (((Shape_Rectangle) o).getY() == getY()) && (((Shape_Rectangle) o).height == height) && (((Shape_Rectangle) o).width == width)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode() + height * 17 + width * 23;
    }

    @Override
    public String toString() {
        return String.format("A rectangle with width %d, height %d at " +
                                     "x-position %d and y-position %d and with hashcode %d", width,
                             height,
                             getX(),
                             getY(), hashCode());
    }
}

