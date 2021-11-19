package io.eholland;

public class Shape_IsoScelesTriangle extends Shape_Triangle {

    // variables
    private static int count;

    // initialisation block
    {
        count++;
    }

    // constructors
    public Shape_IsoScelesTriangle() {
        super();
    }

    public Shape_IsoScelesTriangle(int width, int height) {
        this(width, height, 0, 0);
    }

    public Shape_IsoScelesTriangle(int width, int height, int x, int y) {
        super.setHeight(height);
        super.setX(x);
        super.setY(y);
        setWidth(width);
    }

    public Shape_IsoScelesTriangle(Shape_IsoScelesTriangle isoScelesTriangle) {
        this(isoScelesTriangle.getWidth(), isoScelesTriangle.getHeight(),
             isoScelesTriangle.getX(), isoScelesTriangle.getY());
    }

    // methods
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setPerpendicular(width / 2);
    }

    @Override
    public void setPerpendicular(int width) {
        super.setWidth(width);
        super.setPerpendicular(width/2);
    }

    // referencing to the superclass is not correct in above override methods
    // (as we want to override the method in superclass)
    // however, we did not find the correct mathematical solution; we want to
    // illustrate awareness of how to refer back and being aware of what we
    // SHOULD put (a class specific formula for width and perpendicular)

    @Override
    public String toString() {
        return String.format("An isosceles triangle with height %d, width %d," +
                                     " perpendicular %d, area %f, perimeter %f at position (%d, " +
                                     "%d)", getHeight(), getWidth(), getPerpendicular(), getArea()
                , getPerimeter(), getX(), getY());
    }

    public static int getCount() {
        return count;
    }

}

