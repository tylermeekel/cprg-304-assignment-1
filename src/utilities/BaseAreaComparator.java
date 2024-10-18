package utilities;

import java.util.Comparator;

import shapes.Shape;

public class BaseAreaComparator implements Comparator<Shape> {
	@Override
	public int compare(Shape shape1, Shape shape2) {
        double area1 = shape1.calcBaseArea();
        double area2 = shape2.calcBaseArea();
        return Double.compare(area1, area2);
	}

}
