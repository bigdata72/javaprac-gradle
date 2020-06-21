package topic.core.arrays;

import java.util.Arrays;

public class AllThingsArrays {
	public static void main(String[] args) {
		int [] arr = {1, 5, 3, 5, 5, 2};
		
		System.out.printf("The lowest index of the highest value of the array is %d %n",
		lowIndexMaxValue(Arrays.copyOf(arr,	6)));
		
		Pair<Integer, Integer> pair = getMaxAndLowIndex(Arrays.copyOf(arr, 6));
		System.out.printf("Max value in array = %d, Lowest Index of max value = %d %n",
			pair.getMax(), pair.getLowIndex());
		
		// shuffle
		
		// left shift one
		
		// to Integer array (naive)
		
		// to Integer array (streams)
		
		// arrayCopy
		
		// reverse
		
		// palindrome
		
		//max
		
		//min
		
		
	}
	
	public static int lowIndexMaxValue(int [] arr){
		System.out.println("arr = " + Arrays.toString(arr));
		int max = arr[0];
		int index = 0;
		for(int i=1; i<arr.length; i++){
			if(arr[i] > max) {
				max = arr[i];
				index = i;
			}
		}
		return index;
	}
	
	public static Pair<Integer, Integer> getMaxAndLowIndex(int [] a){
		System.out.println("arr = " + Arrays.toString(a));
		Pair<Integer, Integer> pair = null;
		int max = a[0];
		int index = 0;
		for(int i=1; i<a.length; i++){
			if(a[i] > max) {
				max = a[i];
				index = i;
			}
		}
		pair = new Pair<>(max, index);
		return pair;
	}
	
	public static void shuffle(int [] a){
		System.out.println("a = " + Arrays.toString(a));
		for(int i=0; i< a.length; i++){
			int j = (int) (Math.random() * (i+1));
			// 0<=j<=1
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		System.out.println("Afer shuffle, a =" + Arrays.toString(a));
	}
	
	public static void shiftLeftOne(int [] a){
		System.out.println("a = " + Arrays.toString(a));
		int first = a[0];
		for(int i=1; i<a.length;i++){
			a[i-1]=a[i];
		}
		a[a.length -1] = first;
		System.out.println("a after shift left one = " + Arrays.toString(a));
	}
	
	public static Integer[] toIntegerArrayNaive(int [] a){
		System.out.println("a = " + Arrays.toString(a));
		Integer[] ints = new Integer[a.length];
		for(int i=0; i<a.length; i++){
			ints[i] = Integer.valueOf(a[i]);
		}
		System.out.println("a after = " + Arrays.toString(a));
		return ints;
	}
	
	public static Integer[] toIntegerArrStream(int[] a){
		System.out.println("a = " + Arrays.toString(a));
		return Arrays.stream(a)
				.boxed()
				.toArray(Integer[] :: new);
	}
	
	public static void arrayCopy(int[] src, int srcPos, int[] target, int tgtPos, int len){
		System.arraycopy(src, srcPos,target, tgtPos, len);
	}
	
	public static int[] reverse(int [] a){
		System.out.println("a = " + Arrays.toString(a));
		int [] rev = new int[a.length];
		for(int i =a.length -1, j=0 ; j < a.length ; i--, j++){
			rev[j] = a[i];
		}
		System.out.println("rev = " + Arrays.toString(rev));
		return rev;
	}
	
	public static boolean palidrome(String str){
		System.out.println("str = " + str);
		if(str == null || str.trim().equals(""))
			return false;
		int len = str.length();
		for(int i=0; i<len/2; i++){
			if(str.toLowerCase().charAt(i) != str.toLowerCase().charAt(len - i -1))
				return false;
		}
		return true;
	}
	
	public static int max(int [] a){
		int max = a[0];
		for(int i=1; i<a.length;i++){
			if(a[i] > max) max = a[i];
		}
		return max;
	}
	
	public static int min(int [] a){
		int min = a[0];
		for(int i=1; i<a.length;i++){
			if(a[i] < min) min = a[i];
		}
		return min;
	}
	
} // AllThingsArrays

class Pair<X, Y>{
	X max;
	Y lowIndex;
	
	public Pair(X x, Y y){
		this.max = x;
		this.lowIndex = y;
	}
	
	public X getMax() {
		return max;
	}
	
	public Y getLowIndex() {
		return lowIndex;
	}
}