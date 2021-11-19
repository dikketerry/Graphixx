package io.eholland;

import java.util.Arrays;
import java.util.Objects;

public class DrawableArray implements Drawable {
    private static int count;
    public Drawable[] drawables;
    private int size;

    {
        count++;
    }

    public DrawableArray() {
        drawables = new Drawable[100];
        size = 0;
    }

    public void add(Drawable d) {

        int index = findElementIndex(null); // find the 1st null in array of
        // drawables, as that is the position we want to add a new drawable to

        if(findElementIndex(d) != -1) { // check if the drawable we want to
            // add, already exists in the array of drawables.
            return; // if it does exist, we exit (we don't add)
        }

        if (index == -1) { // check if array is full / has no empty places
            drawables = Arrays.copyOf(drawables, drawables.length + 1);
            index = drawables.length - 1;
        }

        drawables[index] = d;
        size++;
    }

    public void remove(Drawable d) {
        int index = findElementIndex(d);
        if (index == -1) {
            return;
        }
        drawables[index] = null;
        size--;
    }

    private int findElementIndex(Drawable d) {       // private method to help
        for (int i = 0; i < drawables.length; i++) { // with add/remove. Loops
            if (Objects.equals(drawables[i], d)) {   // through array and com-
                return i;                            // pares d with objects in
            }                                        // array. If it finds, the
        }                                            // index is returned
        return -1;          // d is not found in array - return -1
    }

    public void clear() {
        Arrays.fill(drawables, null);
    }

    public int getSize() {
        return size;
    }

    public static int count() {
        return count;
    }

    @Override
    public void scale(int factor) {
        for (Drawable drawable : drawables) {
            if (drawable != null) {
                drawable.scale(factor);
            }
        }
    }
    // on each drawable we apply the scaling method with its factor given

    @Override
    public void draw(DrawingContext dc) {
        for (Drawable drawable : drawables) {
            if (drawable != null) {
                drawable.draw(dc);
            }
        }
    }
    // on each drawable we apply the draw method with its dc (drawing
    // context) given

    @Override
    public String toString() {                          // create empty string,
        String toReturn = "";                           // loop through array,
        for (Drawable drawable : drawables) {           // filter out nulls,
            if (drawable != null) {                     // fill string with spe-
                toReturn += drawable.toString() + "\n"; // cific toString from
            }                                           // each individual
        }                                               // toString and add
        return toReturn;                                // a linebreak. Return.
    }
}

