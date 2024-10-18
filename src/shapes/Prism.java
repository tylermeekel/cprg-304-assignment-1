package shapes;

public abstract class Prism extends Shape {
	/**
	 * Creates a cone with the specified height and radius
	 * @param height
	 * @param edgeLength
	 */
	private double edgeLength;
	

	public Prism(double height, double edgeLength) {
		super(height);
		this.edgeLength = edgeLength;
	}


	/**
	 * Returns the side of the Prism
	 * @return the side
	 */
	public double getEdgeLength() {
		return this.edgeLength;
	}


	/**
	 * Sets the side of the Prism.
	 * @param side the side to set
	 */
	public void setEdgeLength(double edgeLength) {
		this.edgeLength = edgeLength;
	}


	@Override
	public double calcBaseArea() {
		return 0;
	}


	@Override
	public double calcVolume() {
		return calcBaseArea() * getHeight();
	}



}
