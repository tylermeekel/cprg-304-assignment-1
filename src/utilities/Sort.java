package utilities;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import shapes.Shape;

public class Sort {

    // Bubble Sort using Comparator
    public static <T> void bubbleSort(T[] array, Comparator<? super T> comparator){		
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (comparator.compare(array[j], array[j + 1]) < 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
    
    // Insertion Sort using Comparator
    public static <T> void insertionSort(T[] array, Comparator<? super T> comparator) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            T key = array[i];
            int j = i - 1;

            while (j >= 0 && comparator.compare(array[j], key) > 0) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }

    // Selection Sort using Comparator
    public static <T> void selectionSort(T[] array, Comparator<? super T> comparator) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; 
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(array[j], array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            T temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    // Merge Sort using Comparator
    public static <T> void mergeSort(T[] array, Comparator<? super T> comparator) {
        T[] newArray = mergeSortRecursive(array, comparator);
        for (int i = 0; i < array.length; i++) {
            array[i] = newArray[i];
        }
    }

    private static <T> T[] mergeSortRecursive(T[] array, Comparator<? super T> comparator) {
        int n = array.length;

        if (n <= 1) {
            return array;
        }

        T[] arrayOne = Arrays.copyOfRange(array, 0, n / 2);
        T[] arrayTwo = Arrays.copyOfRange(array, n / 2, n);

        arrayOne = mergeSortRecursive(arrayOne, comparator);
        arrayTwo = mergeSortRecursive(arrayTwo, comparator);

        return merge(arrayOne, arrayTwo, comparator);
    }

    private static <T> T[] merge(T[] arrayA, T[] arrayB, Comparator<? super T> comparator) {
        int totalLength = arrayA.length + arrayB.length;
        T[] arrayC = (T[]) new Object[totalLength];

        int indexA = 0;
        int indexB = 0;
        int indexC = 0;

        while (indexA < arrayA.length && indexB < arrayB.length) {

            if (comparator.compare(arrayA[indexA], arrayB[indexB]) < 0) {
                arrayC[indexC] = arrayA[indexA];
                indexA++;
            } else {
                arrayC[indexC] = arrayB[indexB];
                indexB++;
            }

            indexC += 1;
        }

        while (indexA < arrayA.length) {
            arrayC[indexC] = arrayA[indexA];
            indexA++;
            indexC++;
        }

        while (indexB < arrayB.length) {
            arrayC[indexC] = arrayB[indexB];
            indexB++;
            indexC++;
        }

        return arrayC;
    }

    // Quick Sort using Comparator
    public static <T> void quickSort(T[] array, int low, int high, Comparator<? super T> comparator) {
        if (low < high) {
            // Find the partition index
            int pi = partition(array, low, high, comparator);
            // Recursively sort elements before and after partition
            quickSort(array, low, pi - 1, comparator);
            quickSort(array, pi + 1, high, comparator);
        }
    }

    private static <T> int partition(T[] array, int low, int high, Comparator<? super T> comparator) {
        // Choose the rightmost element as the pivot
        T pivot = array[high];
        int i = (low - 1); // Index of the smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (comparator.compare(array[j], pivot) <= 0) {
                i++;
                // Swap arr[i] and arr[j]
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Swap arr[i + 1] and the pivot (arr[high])
        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1; 
    }
	public static void bogoSort(Shape[] shapes) {
        Random random = new Random();

        while (!isSorted(shapes)) {
            for (int i = 0; i < shapes.length; i++) {
                int randomIndexToSwap = random.nextInt(shapes.length);
                Shape temp = shapes[i];
                shapes[i] = shapes[randomIndexToSwap];
                shapes[randomIndexToSwap] = temp;
            }
        }
    }
	// Helper method to check if the array is sorted
    private static boolean isSorted(Shape[] shapes) {
        for (int i = 0; i < shapes.length - 1; i++) {
            if (shapes[i].compareTo(shapes[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

}