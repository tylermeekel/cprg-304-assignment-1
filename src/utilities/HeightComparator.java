package utilities;

import java.util.Comparator;
import shapes.Shape;

public class HeightComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        if (shape1.getHeight() < shape2.getHeight()) return 1; 
        if (shape1.getHeight() > shape2.getHeight()) return -1; 
        return 0;
    }
}