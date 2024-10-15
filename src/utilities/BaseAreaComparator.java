package utilities;

import java.util.Comparator;

import shapes.Shape;

public class BaseAreaComparator implements Comparator<Shape> {

	public BaseAreaComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Shape shape1, Shape shape2) {
		if(shape1.calcBaseArea() > shape2.calcBaseArea() ) return 1;
		if(shape1.calcBaseArea() < shape2.calcBaseArea()) return -1;
		return 0;
	}

}
