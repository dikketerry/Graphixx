package io.eholland;

import io.eholland.shapes.Line;

public class AppSwitchLineLoop {
    public static void main(String[] args) {

        int height = 900;
        int width = 900;

        int centX = width / 2;
        int centY = height / 2;
        int x = 20;
        int y = 20;
        int lastX = centX;
        int lastY = centY;
        float expand = 1;

        DrawableArray shapeArray = new DrawableArray();

        for (int i = 0; i < 99; i++) {
            float lineNoise =
                    (float) Math.floor(Math.random() * Math.pow((Math.E),
                                                                Math.E)) * expand;
            int randomOneToFive = (int) Math.floor(Math.random() * 5);
//        System.out.println(randomOneToFive);
            switch(randomOneToFive) {
                case 1:
                    Line l = new Line(x, y, lastX, lastY);
                    shapeArray.add(l);
                    x = (int) (lastX / expand);
                    y = (int) (lastY / expand);
                    lastX = (int) (x + (Math.PI * lineNoise));
                    expand += 0.3f;
                    break;
                case 2:
                    Line l2 = new Line(x, y, lastX, lastY);
                    shapeArray.add(l2);
                    x = (int) (lastX * expand);
                    y = (int) (lastY * expand);
                    lastX = (int) (x + (Math.PI * lineNoise));
                    expand += 0.4f;
                    break;
                case 3:
                    Line l3 = new Line(x, y, lastX, lastY);
                    shapeArray.add(l3);
                    x = (int) (lastX / expand);
                    y = (int) (lastY / expand);
                    lastX = (int) (x + (Math.PI * lineNoise));
                    expand += 0.5f;
                    break;
                case 4:
                    Line l4 = new Line(x, y, lastX, lastY);
                    shapeArray.add(l4);
                    x = (int) (lastX * expand);
                    y = (int) (lastY * expand);
                    lastX = (int) (x + (Math.PI * lineNoise));
                    expand += 0.6f;
                    break;
                case 5:
                    Line l5 = new Line(x, y, lastX, lastY);
                    shapeArray.add(l5);
                    x = (int) (lastX / expand);
                    y = (int) (lastY / expand);
                    lastX = (int) (x + (Math.PI * lineNoise));
                    expand += 0.7f;
                    break;
            }
        }

        Gui gui = new Gui(height, width);
        gui.add(shapeArray);

        System.out.println(shapeArray);
    }
}
