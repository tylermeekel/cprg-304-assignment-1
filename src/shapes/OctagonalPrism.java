package shapes;

public class OctagonalPrism extends Prism
{
    public OctagonalPrism(double height, double side) {
        super(height, side);
    }

    @Override
    public double calcBaseArea() {
        return 2*(1 + Math.sqrt(2) * Math.pow(getSide(),2));
    }

    @Override
    public String toString() {
        return "OctagonalPrism with height: " + getHeight() + " and edge length: " + getSide();
    }

}
