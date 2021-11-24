package io.eholland;

import io.eholland.shapes.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MyCanvas extends Canvas {

    private static List<Drawable> drawables = new ArrayList<>();
    public static void add(Drawable drawable) {
        drawables.add(drawable);
    }

    public void paint(Graphics g) {
        for (Drawable drawable : drawables) {

            if (drawable instanceof Line) {
                Line line = (Line) drawable;
                g.setColor(Color.BLACK);
                g.drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
            } else if (drawable instanceof Shape_Circle) {
                Shape_Circle circle = (Shape_Circle) drawable;
                g.setColor(Color.YELLOW);
                g.fillOval(circle.getX(), circle.getY(), circle.getRadius(),
                        circle.getRadius());
            } else if (drawable instanceof Shape_Oval) {
                Shape_Oval oval = (Shape_Oval) drawable;
                g.setColor(Color.BLUE);
                g.fillOval(oval.getX(), oval.getY(), oval.getMajorRadius(),
                        oval.getMinorRadius());
            } else if (drawable instanceof Shape_Square) {
                Shape_Square square = (Shape_Square) drawable;
                g.setColor(Color.red);
                g.fillRect(square.getX(), square.getY(), square.getSide(),
                        square.getSide());
            } else if (drawable instanceof Shape_Rectangle) {
                Shape_Rectangle rectangle = (Shape_Rectangle) drawable;
                g.setColor(Color.gray);
                g.fillRect(rectangle.getX(), rectangle.getY(),
                        rectangle.getWidth(), rectangle.getHeight());
//            } else if (drawable instanceof Shape_Triangle) {
//                Shape_Triangle triangle = (Shape_Triangle) drawable;
//                g.setColor(Color.cyan);
//                g.fill
            }
        }
    }
}
