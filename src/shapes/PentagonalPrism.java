package shapes;

public class PentagonalPrism extends Prism
{
    /**
	 * Creates a cone with the specified height and radius
	 * @param height
	 * @param edgeLength
	 */

    public PentagonalPrism(double height, double edgeLength) {
        super(height, edgeLength);
    }

    @Override
    public double calcBaseArea() {
        return (5 * Math.pow(getEdgeLength(), 2) * Math.tan(Math.toRadians(54))) / 4;
    }
    public String getShapeName() {
        return "PentagonalPrism";
    }

}
