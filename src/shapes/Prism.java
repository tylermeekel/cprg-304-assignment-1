package shapes;

public abstract class Prism extends Shape {
    private double side;


    /**
     * Creates a Prism with specified height and side.
     * @param height
     * @param side
     */
    public Prism(double height, double side) {
        super(height);
        this.side = side;
    }


    /**
     * Returns the side of the Prism
     * @return the side
     */
    public double getSide() {
        return side;
    }


    /**
     * Sets the side of the Prism.
     * @param side the side to set
     */
    public void setSide(double side) {
        this.side = side;
    }


    public Prism() {
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
