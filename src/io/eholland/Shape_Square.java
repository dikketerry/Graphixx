package io.eholland;

public class Shape_Square extends Shape_Rectangle {

    // variables
    private static int count;

    // initialisation block
    {
        count++;
    }

    // constructors
    public Shape_Square() {
        this(0);
    }

    public Shape_Square(int side) {
        this(side,0,0);
    }

    public Shape_Square(int side, int x, int y) {
        super(side, side, x, y);
    }

    public Shape_Square(Shape_Square square) {
        this(square.getSide(), square.getX(), square.getY());
    }

    // methods
    public void setSide (int side) {
        super.setHeight(side);
        super.setWidth(side);
    }

    public int getSide() {
        return getWidth();
    }

    @Override
    public void setHeight(int height) {
        setSide(height);
    }

    @Override
    public void setWidth (int width) {
        setSide(width);
    }

    public String toString() {
        return String.format("A square with side %d, area %f and at position " +
                                     "(%d, %d)", getSide(), getArea(),
                             getX(), getY());
    }

    public static int getCount() {
        return count;
    }
}

