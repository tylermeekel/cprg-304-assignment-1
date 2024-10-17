package shapes;

public class SquarePrism extends Prism
{

    public SquarePrism(double height, double edgeLength) {
        super(height, edgeLength);
    }

    @Override
    public double calcBaseArea() {
        return Math.pow(getEdgeLength(), 2);
    }
}
