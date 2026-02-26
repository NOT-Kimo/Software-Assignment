package project.shapes;

public class Rectangle implements Shape {
    private double width, height;

    public Rectangle(double w, double h) {
        width = w;
        height = h;
    }

    public Rectangle() {
        width = 0;
        height = 0;
    }

    @Override
    public Shape copy() {
        return new Rectangle(width, height);
    }

    public void setDimenstion(double w, double h) {
        width = w;
        height = h;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.area(), other.area());
    }

    @Override
    public String getType() {
        return "Rectangle";
    }
}
