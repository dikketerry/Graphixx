package io.eholland;

import io.eholland.shapes.*;

// simple test
public class AppSimpleTest {

    public static void main(String[] args) {

        int height = 900;
        int width = 900;

        DrawableArray shapeArray = new DrawableArray();

        Shape_Rectangle r = new Shape_Rectangle(200, 300, 20, 50);
        Shape_Circle c = new Shape_Circle(96, 560, 371);
        Shape_Square sq = new Shape_Square(107, 344, 621);
        Shape_Oval o = new Shape_Oval(72, 144, 555, 211);
        Line l = new Line(100, 100, 720, 330);
//        Shape_IsoScelesTriangle i = new Shape_IsoScelesTriangle(111,
//                88, 543, 701);
//        Shape_Triangle t = new Shape_Triangle(40, 60, 20, 600, 700);

        shapeArray.add(r, c, sq, o, l);

        Gui gui = new Gui(height, width);
        gui.add(shapeArray);

        System.out.println(shapeArray);
    }
}
