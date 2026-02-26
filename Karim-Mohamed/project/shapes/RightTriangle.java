package project.shapes;

public class RightTriangle implements Shape {
    private double base, height, hypo;

    public RightTriangle(double b, double h) {
        base = b;
        height = h;
        hypo = Math.hypot(b, h);
    }

    public RightTriangle() {
        base = 0;
        height = 0;
        hypo = 0;
    }

    @Override
    public Shape copy() {
        return new RightTriangle(base, height);
    }

    public void setDimenstion(double b, double h) {
        base = b;
        height = h;
        hypo = Math.hypot(b, h);
    }

    @Override
    public double area() {
        return (0.5 * base * height );
    }

    @Override
    public double perimeter() {
        return base + height + hypo;
    }

    public double getHypotenuse() {
        return hypo;
    }

    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.area(), other.area());
    }

    @Override
    public String getType() {
        return "RightTriangle";
    }
}
