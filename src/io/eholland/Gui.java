package io.eholland;

import javax.swing.*;

public class Gui implements DrawingContext {

    private JFrame frame;
    private GraphicalJComponent graphicalJComponent;

    public Gui(int w, int h) {
        frame = new JFrame();
        frame.setSize(w, h);
        frame.setTitle("Testing shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        graphicalJComponent = new GraphicalJComponent();
        frame.add(graphicalJComponent);

    }

    public void add(DrawableArray s){
        for(int i = 0; i < s.getSize(); i++){
            graphicalJComponent.add(s.drawables[i]);
        }
    }

    @Override
    public void draw(Shape shape) {

    }

    @Override
    public void draw(Line line) {

    }

}

