package shapes;

public abstract class Shape implements Comparable<Shape>{
	private double height;
    public abstract double calcBaseArea();
	public abstract double calcVolume();
	
	

/// create shape object with specified height.
	public double getHeight() {
		return this.height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	/**
	 * @param height
	 */
	public Shape(double height) {
		super();
		this.height = height;
	}
	
	@Override
	public int compareTo(Shape other) {
		if(this.height > other.height) return 1;
		if(this.height < other.height) return -1;
		return 0;
		
	}
	@Override
	public String toString() {
		return "(Height: " + getHeight() + ", Base Area: " + calcBaseArea() + ", Volume: "
				+ calcVolume() + ")";
	}
	
	
	
}
