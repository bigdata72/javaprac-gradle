package topic.algorithms.sort;

import java.util.Arrays;

public class FirstInsertionSort {
	public static void main(String[] args) {
		Integer[] arrToSort = {8, 7, 5, 2, 4, 6, 3};
		mySort(copyArray(arrToSort));
		System.out.println("=================================");
		cormenBookInsertionSort(copyArray(arrToSort));
		System.out.println("Final Sorted array = "+Arrays.toString(arrToSort));
	}

	public static void mySort(Integer[] a) {
		int len = a.length;
		int index = 0;
		int marker = index + 1;
		System.out.println("Original unsorted array = "+Arrays.toString(a));
		while(marker < len ) {
			System.out.println("Marker index ="+marker +", value at this index ="+a[marker]);
			for(int i = marker; i > 0; i--){
				int a2 = a[i];
				int a1 = a[i-1];
				if(a2 < a1){
					// not sorted, swap
					a[i] = a1;
					a[i-1] = a2;
					System.out.println(Arrays.toString(a));
				}else break;
			}
			marker++;
		}
		//Integer[] arrToSort = {8, 7, 5, 2, 4, 6, 3};
	}
	
	public static void cormenBookInsertionSort(Integer [] a) {
		int len = a.length;
		//[8, 7, 5, 2, 4, 6, 3]
		System.out.println("Unsorted array = "+Arrays.toString(a));
		for (int j = 1; j < len; j++) {
			System.out.println("Marker index ="+j +", value at this index ="+a[j]);
			int key = a[j];
			int i = j -1;
			while(i >= 0 && a[i] > key){
				a[i+1] = a[i]; // move to right
				i--;
			}
			a[i+1] = key;
			System.out.println(Arrays.toString(a));
		}
	}
	
	private static Integer[] copyArray(Integer [] arr){
		Integer [] clone = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++) {
			clone[i] = arr[i];
		}
		return clone;
	}
}



/**
 TODO 1) add method to verify if it is sorted
 TODO 2) add unit test
 TODO 3) add corman algo - DONE
 TODO 4) add performance benchmark for comparision using large files
 */
