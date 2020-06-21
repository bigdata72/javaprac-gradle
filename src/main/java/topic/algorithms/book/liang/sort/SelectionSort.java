package topic.algorithms.book.liang.sort;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int [] arr = {2, 9, 5, 4, 8, 1, 6};
		int [] copy = new int[7];
		System.arraycopy(arr, 0, copy, 0, 7);
		selectionSort(copy);
		System.out.println("----");
		int [] copy2 = new int[7];
		System.arraycopy(arr, 0, copy2, 0, 7);
		selectionSort2(copy2);
	}
	
	public static void selectionSort2(int [] a){
		System.out.println("a = " + Arrays.toString(a));
		for(int i=0; i<a.length -1; i++){
			int min = a[i];
			int minIndex = i;
			for(int j=i+1; j<a.length; j++){
				if(min > a[j]){
					min = a[j];
					minIndex =j;
				}
			}
			// swap the elements if the index are different
			if(minIndex != i) {
				int temp = a[i];
				a[i] = a[minIndex];
				a[minIndex] = temp;
			}
		}
		System.out.println("After selection sort, array ="+Arrays.toString(a));
	}
	
	public static void selectionSort(int [] arr){
		
		System.out.println(Arrays.toString(arr));
		
		for(int i=0; i<arr.length;i++){
			int lowIndex = minIndex(arr,i);
			System.out.println("i="+i);
			System.out.println("lowIndex="+lowIndex);
			
			swap(arr, i, lowIndex);
			System.out.println(Arrays.toString(arr));
		}
	}
	

	private static int minIndex(int[] arr, int from){
		int min = arr[from];
		int index = from;
		for(int i=from+1; i<arr.length; i++){
			if(arr[i] < min) {
				min = arr[i];
				index = i;
			}
		}
		return index;
	}
	
	private static void swap(int [] arr, int n1, int n2){
		System.out.println("swapping index positions - "+n1 +" and "+n2);
		int temp = arr[n1];
		arr[n1] = arr[n2];
		arr[n2] = temp;
	}
	
	private static int[] arrayCopy(int[] arr, int from, int to){
		int[] result = new int[arr.length -1];
		for(int i=0; i< result.length; i++){
			result[i] = arr[from+i];
		}
		System.out.println(Arrays.toString(result));
		return result;
	}
	
}
