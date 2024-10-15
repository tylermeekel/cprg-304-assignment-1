package utilities;
import java.util.Comparator;

import shapes.*;


public class InsertionSort {
    public static void insertionSort(Shape[] shapes, Comparator<Shape> comparator) {
        for (int i = 1; i < shapes.length; i++) {
            Shape key = shapes[i];
            int j = i - 1;
            while (j >= 0 && comparator.compare(shapes[j], key) > 0) {
                shapes[j + 1] = shapes[j];
                j--;
            }
            shapes[j + 1] = key;
        }
    }
    
    public static void sortByHeight(Shape[] shapes) {
        insertionSort(shapes, Comparator.naturalOrder());
    }
    
    public static void sortByBaseArea(Shape[] shapes) {
        insertionSort(shapes, new BaseAreaComparator());
    }
    
    public static void sortByVolume(Shape[] shapes) {
        insertionSort(shapes, new VolumeComparator());
    }

    public static void printShapes(Shape[] shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}