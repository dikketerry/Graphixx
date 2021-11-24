package io.eholland;

import io.eholland.shapes.Line;
import io.eholland.shapes.Shape;

public interface DrawingContext {
    void draw(Shape shape);
    void draw(Line line);
}

