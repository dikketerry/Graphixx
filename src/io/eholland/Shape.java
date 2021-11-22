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
    public void setX(int x) throws RuntimeException { // not needed here? as
        if (x < 0) {                      // a shape will not be instantiated?
            throw new NegativeNumberException("negative x-coordinate shape");
        }
        this.x = x;
    }

    public void setY(int y) throws RuntimeException {
        if (y < 0) {
            throw new NegativeNumberException("negative y-coordinate shape");
        }
        this.y = y;
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

//    public int makeAbsolute(int originalValue) {
//        return Math.abs(originalValue);
//    }

    // abstract methods
    public abstract float getArea();

    public abstract float getPerimeter();

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

