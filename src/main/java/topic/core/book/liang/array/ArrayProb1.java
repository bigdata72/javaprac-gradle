package topic.core.book.liang.array;

import java.util.Arrays;

public class ArrayProb1 {
	public static void main(String[] args) {
		// 9 is largest element found at index 5, 6, 9
		// method should return 5
		int [] arr = {2, 3, 7, 8, 7, 9, 9, 6, 5, 9};
		smallestIndexOfLargestElement(copy(arr));
		shuffle(copy(arr));
		shift(copy(arr));
		reverse(copy(arr));
		intOverflow();
	}
	
	private static int[] copy(int[] src){
		int[] dst = new int[src.length];
		for(int i=0; i< src.length; i++){
			dst[i] = src[i];
		}
		return dst;
	}
	public static void smallestIndexOfLargestElement(int [] arr){
		System.out.println("smallestIndexOfLargestElement()......");
		System.out.println("Array="+ Arrays.toString(arr));
		int len = arr.length;
		int lowIndex = 0;
		int max = arr[0];
		for(int i=1; i < len; i++){
			if (arr[i] > max){
				max = arr[i];
				lowIndex = i;
			}
		}
		System.out.printf("Max is = %d and lowest index=%d", +max, +lowIndex);
	}
	
	public static void shuffle(int[] arr){
		System.out.println("shuffle()......");
		System.out.println("Array="+ Arrays.toString(arr));
		for(int i =arr.length -1; i>=0; i--) {
			int j = (int) (Math.random() * (i + 1));
			System.out.println("i="+i+", arr["+i+"]="+arr[i]+", j="+j);
			int temp = arr[j];
			arr[j] = arr[i];
			arr[i] = temp;
		}
		System.out.println("Shuffled array ="+Arrays.toString(arr));
	}
	
	public static void shift(int[] arr){
		System.out.println("shift()......");
		System.out.println("Array="+ Arrays.toString(arr));
		int temp = arr[0];
		for(int i=1; i < arr.length; i++){
			arr[i-1]=arr[i];
		}
		arr[arr.length -1] = temp;
		System.out.println(Arrays.toString(arr));
	}
	
	public static void reverse(int [] arr){
		System.out.println("reverse()......");
		System.out.println("Array="+ Arrays.toString(arr));
		// traverse half the length to reverse
		for(int i=0, j=arr.length-1; i < arr.length/2; i++, j--){
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		System.out.println("After:"+Arrays.toString(arr));
	}
	
	private static void intOverflow(){
		long low = 10;
		long high = Integer.MAX_VALUE;
		System.out.println("High="+high);
		System.out.println("(low+high)="+(low+high));
		boolean overflow = (low+high) > Integer.MAX_VALUE;
		System.out.println("(low+high) > Integer.MAX_VALUE=" +overflow);
		int result =(int)( (low+high) >Integer.MAX_VALUE? Integer.MAX_VALUE:(low+high));
		System.out.println("Result ="+result);
	}
}
