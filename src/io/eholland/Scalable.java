package io.eholland;

public interface Scalable {

    int QUARTER = 25;
    int HALF = 50;
    int DOUBLE = 200;

    void scale(int factor);

    default void scaleDouble() {
        scale(DOUBLE);
    }

    default void scaleHalf() {
        scale(HALF);
    }

    default void scaleQuarter() {
        scale(QUARTER);
    }

}

