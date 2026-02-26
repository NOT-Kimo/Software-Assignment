package project.shapes;

public interface Shape {

    double area();

    double perimeter();

    int compareTo(Shape other);

    String getType();

    Shape copy();
}