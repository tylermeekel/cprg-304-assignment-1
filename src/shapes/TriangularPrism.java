package shapes;

public class TriangularPrism extends Prism
{


    public TriangularPrism(double height, double side) {
        super(height, side);
    }
    @Override
    public double calcBaseArea() {
        return (Math.pow(getSide(), 2) * Math.sqrt(3))/4;
    }

    @Override
    public double calcVolume() {
        return calcBaseArea() * getHeight();
    }

}
