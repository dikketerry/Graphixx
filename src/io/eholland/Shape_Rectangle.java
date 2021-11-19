package io.eholland;

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
    public void setWidth(int width) {
        this.width = makeAbsolute(width);
    }

    public void setHeight(int height) {
        this.height = makeAbsolute(height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int grow(int d) {
        return (getWidth() * d);
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
    public void scale(int factor) {
        setHeight((getHeight() * factor) / 100);
        setWidth((getWidth() * factor) / 100);
    }

    @Override
    public double getArea() {
        return (height * width);
    }

    @Override
    public double getPerimeter() {
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

