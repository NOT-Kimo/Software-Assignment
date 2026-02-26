package project.shapes;

import static java.lang.Math.*;

public class Circle implements Shape {

    private double r;

    public Circle(double r) {
        this.r = r;
    }

    public Circle() {
        this.r = 0;
    }

    @Override
    public Shape copy() {
        return new Circle(r);
    }

    public void setRadius(double newR) {
        r = newR;
    }

    public double getRadius() {
        return r;
    }

    @Override
    public double area() {
        return PI * r * r;
    }

    @Override
    public double perimeter() {
        return 2 * PI * r;
    }

    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.area(), other.area());
    }

    @Override
    public String getType() {
        return "Circle";
    }
}
