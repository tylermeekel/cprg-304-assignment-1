package shapes;

public abstract class Shape implements Comparable<Shape> {

    private double height;
    public abstract double calcBaseArea();
    public abstract double calcVolume();

    // Abstract method to get the shape's name
    public abstract String getShapeName();

    // create shape object with specified height.
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
        if (this.height > other.height) return 1;
        if (this.height < other.height) return -1;
        return 0;
    }

    // Updated toString method that handles the format
    public String toString(String format) {
        switch (format) {
            case "volume":
                return "The polygons." + getShapeName() + " has a Volume of: " + calcVolume();
            case "height":
				return "The polygons." + getShapeName() + " has a Volume of: " + calcBaseArea();
            case "baseArea":
				return "The polygons." + getShapeName() + " has a Volume of: " + getHeight();
            default:
                return getShapeName() + " (Height: " + getHeight() + ", Base Area: " + calcBaseArea() + ", Volume: " + calcVolume() + ")";
        }
    }
}
