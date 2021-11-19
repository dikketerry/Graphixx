package io.eholland;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GraphicalJComponent extends JComponent {

    private static List<Drawable> drawables = new ArrayList<>();
    public static void add(Drawable drawable) {
        drawables.add(drawable);
    }

    @Override
    protected void paintComponent (Graphics g) {
        for (Drawable drawable : drawables) {
            if (drawable instanceof Shape_Rectangle) {
                Shape_Rectangle rectangle = (Shape_Rectangle) drawable;
                g.setColor(Color.BLACK);
                g.fillRect(rectangle.getX(), rectangle.getY(),
                           rectangle.getWidth(), rectangle.getHeight());
            } else if (drawable instanceof Shape_Circle) {
                Shape_Circle circle = (Shape_Circle) drawable;
                g.setColor(Color.YELLOW);
                g.fillOval(circle.getX(), circle.getY(), circle.getRadius(),
                           circle.getRadius());
            } else if (drawable instanceof Line) {
                Line line = (Line) drawable;
                g.setColor(Color.gray);
                g.drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
            }
        }
    }
}
