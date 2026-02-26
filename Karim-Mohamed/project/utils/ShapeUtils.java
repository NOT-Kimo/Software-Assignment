package project.utils;

import project.shapes.Shape;

public class ShapeUtils {
    public static final String SYSTEM_NAME = "Shape Analyzer";
    public static final int RANDOM_ID = new java.util.Random().nextInt();

    public static Shape largest(Shape a, Shape b) {
        return (a.compareTo(b) == 1) ? a : b;
    }

}
