package shapes;

public class Pyramid extends Shape {
    /**
	 * Creates a cone with the specified height and radius
	 * @param height
	 * @param edgeLength
	 */
    private double edgeLength;
    public Pyramid(double height, double edgeLength) {
        super(height);
        this.edgeLength = edgeLength;
    }

    @Override
    public double calcBaseArea() {
        return Math.pow(edgeLength, 2);
    }

    @Override
    public double calcVolume() {
        return (calcBaseArea() * getHeight()) / 3;
    }
    @Override
    public String toString() {
        double baseArea = calcBaseArea();
        double volume = calcVolume();
        if (baseArea == 0){
            return "The polygons.Pyramid has a volume of :" + volume;
        }
        else
            return "The polygons.Pyramid has a BaseArea of :" + baseArea;
    }
}