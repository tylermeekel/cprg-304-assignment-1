package shapes;

public class Cylinder extends Shape {
	private double radius;
	
	/**
	 * Creates a cone with the specified height and radius
	 * @param height
	 * @param radius
	 */
	public Cylinder(double height, double radius) {
		super(height);
		this.radius = radius;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius; 
	}

	@Override
	public double calcBaseArea() {
		return Math.PI * this.radius * this.radius;
	}

	@Override
	public double calcVolume() {
				return this.calcBaseArea() * this.getHeight();
	}
	public String getShapeName() {
        return "Cylinder";
    }
}
