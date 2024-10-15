package shapes;

public class Pyramid extends Shape {
    private double sideLength;
    public Pyramid(double height, double sideLength) {
        super(height);
        this.sideLength = sideLength;
    }

    @Override
    public double calcBaseArea() {
        return Math.pow(sideLength, 2);
    }

    @Override
    public double calcVolume() {
        return (1.0 / 3.0) * calcBaseArea() * getHeight();
    }

    @Override
    public String toString() {
        return "Pyramid with height " + getHeight() + " and base side length " + sideLength;
    }
}