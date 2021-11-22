package io.eholland;

public class Shape_Triangle extends Shape {
    // variables
    public static final int ANGLES = 3;
    private static int count;
    private int height;
    private int width;
    private int perpendicular;

    // initialisation block
    {
        count++;
    }

    // constructors
    public Shape_Triangle() {
        this(0, 0, 0);
    }

    public Shape_Triangle(int width, int height, int perpendicular) {
        this(width, height, perpendicular, 0, 0);
    }

    public Shape_Triangle(int width, int height, int perpendicular, int x,
                          int y) {
        super(x, y);
        setWidth(width);
        setHeight(height);
        setPerpendicular(perpendicular);
    }

    public Shape_Triangle(Shape_Triangle triangle) {
        this(triangle.getWidth(), triangle.getHeight(),
             triangle.getPerpendicular(), triangle.getX(),
             triangle.getY());
    }

    // methods
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) throws RuntimeException {
        if (height < 0) {
            throw new NegativeNumberException("negative height triangle");
        }
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) throws RuntimeException {
        if (width < 0) {
            throw new NegativeNumberException("negative width triangle");
        }
        this.width = width;
    }

    public int getPerpendicular() {
        return perpendicular;
    }

    public void setPerpendicular(int perpendicular) throws RuntimeException {
        if (perpendicular < 0) {
            throw new NegativeNumberException("negative perpendicular " +
                    "triangle");
        }
        this.perpendicular = perpendicular;
    }

    @Override
    public float getArea() {
        return (perpendicular + width) / 2;
    }

    @Override
    public float getPerimeter() {
        return (float) ((width + height) + Math.sqrt((Math.pow(width, 2) + Math.pow(height
                , 2))));
    }

    @Override
    public String toString() {
        return String.format("A triangle with height %d, width %d, area %f, " +
                                     "perpendicular %d at position (%d, %d)", height, width,
                             getArea(), perpendicular, getX(), getY());
    }

    @Override
    public boolean equals(Object o) {
        if ((o != null) && (getClass() == o.getClass()) && (((Shape_Triangle) o).getHeight() == getHeight()) && (((Shape_Triangle) o).getWidth() == getWidth()) && (((Shape_Triangle) o).getPerpendicular() == getPerpendicular())) {
            return true;
        } else return false;
    }

    @Override
    public int hashCode() {
        return (super.hashCode() * perpendicular);
    }

    @Override
    public void scale(float factor) {
        setHeight((int) (getHeight() * factor) / 100);
        setWidth((int) (getWidth() * factor) / 100);
        setPerpendicular((int) (getPerpendicular() * factor) / 100);
    }

    @Override
    public void draw(DrawingContext dc) {
        dc.draw(this); //
    }

    public static int getCount() {
        return count;
    }

}

