package topic.algorithms.sort;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSortImpl {
	
	public static void main (String[] args) {
		String input;
		if (args.length == 0) {
			System.out.println("No pgm arguments. Please enter a word to sort");
			Scanner in = new Scanner(System.in);
			input = in.nextLine();
			System.out.println("Input string is :" + input); // TODO use SLF4J
			selectionSort(input.split(""));
		} else if (args.length == 1) {
			input = args[0];
			if (input != null && !input.trim().isEmpty()) { // TODO Use apache StringUtils
				System.out.println("Input string is :" + input); // TODO use SLF4J
				selectionSort(input.split(""));
			}
		} else {
			System.out.println("Usage: java SelectionSortImpl <InputString> or java SelectionSortImpl");
		}
	}
	
	public static void selectionSort (String[] sortStr) {
		System.out.println("\nselectionSort() called");
		System.out.println("Input string array received is =" + Arrays.toString(sortStr));
		System.out.println("Is input string = '" + Arrays.toString(sortStr) + "' sorted ? " + isSorted(sortStr));
		/*
		                   S    E   L   E   C   T   I   O   N   S   O   R   T
		                   0    1   2   3   4   5   6   7   8   9   10  11  12
		                   
		 */
		
		/**
		 * Steps :
		 * start index = 0
		 * take element at start index, compare with all elements and find smallest
		 * take the smallest element and exchange with element at start index
		 * increment start index
		 * take the next element and do same till all elements are sorted
		 */
		int minIndex = 0;
		int startIndex = 0;
		for (int i = 0; i < sortStr.length; i++) {
			startIndex = i;
			minIndex = i;
			for (int j=startIndex; j < sortStr.length; j++) {
				if (sortStr[j].compareTo(sortStr[minIndex]) < 0) {
					minIndex = j;
				}
				startIndex++;
			}
				exchange(sortStr, i, minIndex);
		}
		
	}
	
	
	public static void exchange (Comparable[] arr, int pos1, int pos2) {
		String temp = arr[pos1].toString();
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}
	
	public static boolean isSorted (Comparable[] arr) {
		
		System.out.println("\nisSorted() called");
		System.out.println("Input array has length =" + arr.length);
		System.out.println("Input array has elements :" + Arrays.toString(arr));
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1].compareTo(arr[i]) > 0) {
				System.out.println("The input array is not sorted\n");
				return false;
			}
		}
		System.out.println("The input array is sorted\n");
		return true;
	}
}

/**
 * Start : Jul 31, 2022
 * implemented selection sort and unit test
 * references :
 * code formatting : https://www.youtube.com/watch?v=vjVWjocENLg
 * assertj docs : https://joel-costigliola.github.io/assertj/assertj-core-quick-start.html
 * IDEA settings : code style custom
 *
 */


