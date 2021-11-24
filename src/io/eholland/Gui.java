package io.eholland;

import io.eholland.shapes.Line;
import io.eholland.shapes.Shape;

import javax.swing.*;
import java.awt.*;

public class Gui /*implements DrawingContext*/ {

    public Gui(int w, int h) {
        JFrame frame = new JFrame();
        MyCanvas canvas = new MyCanvas();
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
            MyCanvas.add(s.drawables[i]);
        }
    }

//    @Override
//    public void draw(Shape shape) {
//
//    }
//
//    @Override
//    public void draw(Line line) {
//
//    }

}

