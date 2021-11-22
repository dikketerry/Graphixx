package io.eholland;

public class GuiApp {
    public static void main(String[] args) {
        int height = 800;
        int width = 800;

        Shape_Rectangle rectangle = new Shape_Rectangle(200, 300, 20, 50);
        Shape_Rectangle rectangle2 = new Shape_Rectangle(111, 200, 200, 500);
        Shape_Rectangle rectangle3 = new Shape_Rectangle(200, 50, 600, 600);
        Line line = new Line(100, 100, 600, 300);

        DrawableArray shapeArray = new DrawableArray();

        shapeArray.add(rectangle, rectangle2, rectangle3, line);

        Gui gui = new Gui(height, width);
        gui.add(shapeArray);

        System.out.println(shapeArray);

    }
}
