package utilities;
import shapes.*;

import java.util.Comparator;

public class VolumeComparator implements Comparator<Shape> {
    @Override
	public int compare(Shape shape1, Shape shape2) {
        if(shape1.calcVolume() > shape2.calcVolume()) return 1;
		if(shape1.calcVolume() < shape2.calcVolume()) return -1;
		return 0;
	}
}