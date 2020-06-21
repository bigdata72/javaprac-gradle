package topic.algorithms.book.algs4ed.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch {
	public static void main(String[] args) {
		// create a sorted list
		List<Integer> list1 = Arrays.asList(3,7,5,9,12,12,15); // odd (7)
		List<Integer> list2 = Arrays.asList(13,27,35,19,122,112); // even (6)
		Collections.sort(list1);
		Collections.sort(list2);
		
		int [] arr1 = new int[] {3,7,5,9,12,12,15};
		int [] arr2 = new int[] {13,27,35,19,122,112};
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		System.out.println(binarySearch(arr1, 12)); // 4
		System.out.println(binarySearch(arr2, 112)); // 5
	}
	
	public static int binarySearch(int[] arr, int key){
		System.out.println(Arrays.toString(arr));
		int len = arr.length;
		int lo = 0;
		int hi = len - 1;
		while(lo <= hi){
			int mid = lo + (hi - lo)/2;
			if(key > arr[mid]){
				System.out.println("Key "+key + ", is > "+arr[mid]);
				lo = mid + 1;
			}else if(key < arr[mid]){
				hi = mid -1;
			}else{
				return mid;
			}
		}
		return -1;
	}
}
