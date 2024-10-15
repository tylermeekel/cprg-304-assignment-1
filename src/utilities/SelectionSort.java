package utilities;
import shapes.*;
import java.util.Comparator;

public class SelectionSort {
    public static void selectionSort(Shape[] shapes, Comparator<Shape> comparator) {
        int n = shapes.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(shapes[j], shapes[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Shape temp = shapes[minIndex];
            shapes[minIndex] = shapes[i];
            shapes[i] = temp;
        }
    }

    public static void sortByHeight(Shape[] shapes) {
        selectionSort(shapes, Comparator.naturalOrder());
    }

    public static void sortByBaseArea(Shape[] shapes) {
        selectionSort(shapes, new BaseAreaComparator());
    }

    public static void sortByVolume(Shape[] shapes) {
        selectionSort(shapes, new VolumeComparator());
    }

    public static void printShapes(Shape[] shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}