package io.eholland.shapes;

import io.eholland.Drawable;
import io.eholland.DrawingContext;

public class Line implements Drawable {

    private static int count;
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    // initialisation block
    {
        count++;
    }

    public Line() {
        this(0, 0, 0, 0);
    }

    public Line(int x2, int y2) {
        this(0, 0, x2, y2);
    }

    public Line(int x1, int y1, int x2, int y2) {
        setLine(x1, y1, x2, y2);
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) throws RuntimeException {
        if (x1 < 0)
//            throw new RuntimeException()
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void setLine(int x1, int y1, int x2, int y2) {
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
    }

    @Override
    public void draw(DrawingContext dc) {
//        Object line = setLine();
        dc.draw(this);
    }

    @Override
    public void scale(float factor) {

    }

    @Override
    public String toString() {
        return String.format("A line starting at x %d, y %d going to x %d and" +
                                     " y %d", getX1(), getY1(), getX2(), getY2());
    }
}

