package utilities;

import java.util.Comparator;

public class Sort {
	/// will sort by height
	public static <T extends Comparable<? super T>> void bubblesort(T[] array) {
		
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			
			int min_idx = i;
			
			for (int j = i + 1; j < n; j++) {
				if (array[j].compareTo(array[min_idx]) < 0) {
					min_idx =j;
				}
			}
		}
		
		// if(min_idx != i) {
		// 	T temp = array[i];
		// 	array[i] = array[min_idx];
		// 	array[min_idx] = temp;
		// }
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
	
	
public static <T extends Comparable<? super T>>void mergesort(T arr[], int l, int r){
		sort(arr, 0, arr.length);
	}
	
	
	private static <T extends Comparable<? super T>>void sort(T arr[], int l, int r){
		
	}
}


