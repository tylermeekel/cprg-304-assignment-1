package shapes;

public class SquarePrism extends Prism
{
    /**
	 * Creates a cone with the specified height and radius
	 * @param height
	 * @param edgeLength
	 */

    public SquarePrism(double height, double edgeLength) {
        super(height, edgeLength);
    }

    @Override
    public double calcBaseArea() {
        return Math.pow(getEdgeLength(), 2);
    }
}
