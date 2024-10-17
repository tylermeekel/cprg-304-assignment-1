package utilities;

import java.util.Arrays;
import java.util.Random;

import shapes.Shape;

public class Sort {
	/// will sort by height
	public static <T extends Comparable<? super T>> void bubbleSort(T[] array) {
		
		int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if(array[j].compareTo(array[j + 1]) < 0) {
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
	
	public static <T extends Comparable<? super T>> void insertionSort(T[] array) {
		int n = array.length;
		for (int i = 1; i < n; i++) {
			T key = array[i];
			int j = i - 1;
	
			while (j >= 0 && array[j].compareTo(key) > 0) {
				array[j + 1] = array[j];
				j--;
			}
	
			array[j + 1] = key;
		}
	}

	public static <T extends Comparable<? super T>> void selectionSort(T[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i; 
			for (int j = i + 1; j < n; j++) {
				if (array[j].compareTo(array[minIndex]) < 0) {
					minIndex = j;
				}
			}
			T temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
	}
	
	
	public static void mergeSort(Shape[] array){
		Shape[] newArray = mergeSortRecursive(array);
		for (int i = 0; i < array.length; i++) {
			array[i] = newArray[i];
		}
	}
	
	private static Shape[] mergeSortRecursive(Shape[] array) {
		int n = array.length;
		
		if (n <= 1) {
			return array;
		}
		
		Shape[] arrayOne = Arrays.copyOfRange(array, 0, n/2);
		Shape[] arrayTwo = Arrays.copyOfRange(array, n/2, n);
		
		arrayOne = mergeSortRecursive(arrayOne);
		arrayTwo = mergeSortRecursive(arrayTwo);
		
		return merge(arrayOne, arrayTwo);
	}
	
	private static Shape[] merge(Shape[] arrayA, Shape[] arrayB) {
		int totalLength = arrayA.length + arrayB.length;
		Shape[] arrayC = new Shape[totalLength];
		
		int indexA = 0;
		int indexB = 0;
		int indexC = 0;
		
		while (indexA < arrayA.length && indexB < arrayB.length) {
			
			
			if (arrayA[indexA].compareTo(arrayB[indexB]) < 0) {
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
	
	public static void bogoSort(Shape[] array) {
		Random rand = new Random();
		
		// if not sorted, randomize array
		while(!checkIfSorted(array)) {
			for (int i = 0; i < array.length; i++) {
				int swapIndex = rand.nextInt(array.length);
				Shape tempValue = array[swapIndex];
				array[swapIndex] = array[i];
				array[i] = tempValue;
			}
		}
	}
	
	private static boolean checkIfSorted(Shape[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i].compareTo(array[i + 1]) > 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void quickSort(Shape[] array) {
		
	}
}




