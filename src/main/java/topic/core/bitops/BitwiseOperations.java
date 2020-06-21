package topic.core.bitops;

public class BitwiseOperations {
	/**
	 * >> right shift op halves
	 * @param args
	 */
	public static void main(String[] args) {
		rightShift();
		leftShift();
		ternaryShift();
		
	}
	
	// halves
	private static void rightShift() {
		int num1 = 1024;
		System.out.println("BinaryString of 1026="+Integer.toBinaryString(1026));
		int half = -2 >> 1;
		System.out.println(Integer.toBinaryString(-2));
		System.out.printf("BinaryString of %d = %s %n ",half, Integer.toBinaryString(half));
		
	}
	
	// doubles
	private static void leftShift() {
		int num1 = 1024;
		System.out.printf("%s << 1 = %s, binary string for %s %n =", num1, (num1 << 1), num1,
		Integer.toBinaryString(num1));
		System.out.printf("%s << 2 = %s, binary string for %s %n =", num1, (num1 << 2), num1,
		Integer.toBinaryString(num1));
	}
	
	private static void ternaryShift(){
		System.out.println(";;;;");
		int num = -2;
		System.out.println(Integer.toBinaryString(-2));
		int num1 = num >>> 1;
		System.out.println(num1);
		System.out.println(Integer.toBinaryString(num1));
	}
}
