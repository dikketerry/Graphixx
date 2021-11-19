package io.eholland;

import javax.swing.*;
import java.awt.*;

public class Gui implements DrawingContext {

    private JFrame frame;
    private MyCanvas canvas;

    public Gui(int w, int h) {
        frame = new JFrame();
        canvas = new MyCanvas();
        canvas.setSize(w, h);
        canvas.setBackground(Color.white);
        frame.add(canvas);
        frame.pack();
        frame.setTitle("Testing shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);



    }

    public void add(DrawableArray s){
        for(int i = 0; i < s.getSize(); i++){
            canvas.add(s.drawables[i]);
        }
    }

    @Override
    public void draw(Shape shape) {

    }

    @Override
    public void draw(Line line) {

    }

}

