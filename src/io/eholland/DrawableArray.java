package io.eholland;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class DrawableArray implements Drawable, Iterable<Drawable> {
    private static int count;
    public Drawable[] drawables;
    private int size;

    {
        count++;
    }

    public DrawableArray() {
        drawables = new Drawable[1000];
        size = 0;
    }

    public void add(Drawable d) {

        int index = findElementIndex(null); // find the 1st null in array

//        if (findElementIndex(d) != -1) { // check if the drawable we want to
//            // add, already exists in the array of drawables.
//            return; // if it does exist, we exit (we don't add)
//        }

        if (index == -1) { // check if array is full / has no empty places
            drawables = Arrays.copyOf(drawables, drawables.length + 1);
            index = drawables.length - 1;
        }

        drawables[index] = d;
        size++;
    }

    public void add(Drawable... drawables) {
        // ... notation allows for inputting different objects or array of
        // objects
        for (Drawable drawable : drawables) {
            add(drawable);
        }
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
    public void scale(float factor) {
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
                toReturn += drawable + "\n";            // cific toString from
            }                                           // each individual
        }                                               // toString and add
        return toReturn;                                // a linebreak. Return.
    }

    @Override
    public Iterator<Drawable> iterator() {
        return new DrawableIterator();
    }

    class DrawableIterator implements Iterator<Drawable> {

        private int indexNextElement = 0;

        @Override
        public boolean hasNext () {
            if (indexNextElement >= drawables.length) {
                throw new NoSuchElementException("no more elements in " +
                        "drawables array");
            }

            if (drawables[indexNextElement] != null) {
                return true;
            } else {
                indexNextElement++;
                return hasNext();
            }
        }

        public Drawable next() {
            return drawables[indexNextElement++];
        }
    }
}

