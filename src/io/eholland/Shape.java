package io.eholland;

public abstract class Shape implements Drawable {
    // variables
    private static int count;
    private int x;
    private int y;

    // initialisation block
    {
        count++;
    }

    // constructors
    public Shape() {
        this(0, 0);
    }

    public Shape(int x, int y) {
        setPosition(x, y);
    }

    // methods
    public void setX(int x) {
        this.x = makeAbsolute(x);
    }

    public void setY(int y) {
        this.y = makeAbsolute(y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        setX(x);
        setY(y);
    }

    public int makeAbsolute(int originalValue) {
        return Math.abs(originalValue);
    }

    // abstract methods
    public abstract double getArea();

    public abstract double getPerimeter();

    // static method
    public static int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if ((o != null) && (getClass() == o.getClass()) && (((Shape) o).getX() == getX()) && (((Shape) o).getY() == getY())) {
            return true;
        } else return false;
    }

    @Override
    public int hashCode() {
        return x * y;
    }

}

