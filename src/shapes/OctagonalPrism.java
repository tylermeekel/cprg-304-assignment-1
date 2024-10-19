package shapes;

public class OctagonalPrism extends Prism
{
    /**
	 * Creates a cone with the specified height and radius
	 * @param height
	 * @param side
	 */

    public OctagonalPrism(double height, double side) {
        super(height, side);
    }

    @Override
    public double calcBaseArea() {
        return 2*(1 + Math.sqrt(2) * Math.pow(getEdgeLength(),2));
    }
    
	public String toStringBaseArea() {
		return "The Polygon.OctagonalPrism has a Base Area of " + calcBaseArea();
	}
    public String getShapeName() {
        return "OctagonalPrism";
    }
}
