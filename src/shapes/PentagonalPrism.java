package shapes;

public class PentagonalPrism extends Prism
{

    public PentagonalPrism(double height, double edgeLength) {
        super(height, edgeLength);
    }

    @Override
    public double calcBaseArea() {
        return (5 * Math.pow(getEdgeLength(), 2) * Math.tan(Math.toRadians(54))) / 4;
    }

}
