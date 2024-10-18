package shapes;

public class TriangularPrism extends Prism
{
    /**
	 * Creates a cone with the specified height and radius
	 * @param height
	 * @param edgeLength
	 */

    public TriangularPrism(double height, double edgeLength) {
        super(height, edgeLength);
    }
    @Override
    public double calcBaseArea() {
        return (Math.pow(getEdgeLength(), 2) * Math.sqrt(3))/4;
    }
}
