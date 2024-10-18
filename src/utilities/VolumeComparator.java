package utilities;
import shapes.*;

import java.util.Comparator;

public class VolumeComparator implements Comparator<Shape> {
    @Override
	public int compare(Shape shape1, Shape shape2) {
        double area1 = shape1.calcVolume();
        double area2 = shape2.calcVolume();
        return Double.compare(area1, area2);
	}
}