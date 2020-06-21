package topic.algorithms.book.liang;

import java.util.Arrays;

public class Fibonacci {
	static int [] fib;
	static int [] fib2;
	
	public static void main(String[] args) {
		int n = 50;
		fib = new int[n+1];
		long start = System.nanoTime();
		System.out.println("Fibonacci("+n+")="+fiboExponential(n));
		long duration = System.nanoTime() - start;
		System.out.println("fiboExponential("+n+") took "+duration/1000000 +" milliseconds");
		System.out.println(Arrays.toString(fib));
		
		fib2 = new int[n+1];
		start = System.nanoTime();
		System.out.println("Fibonacci("+n+")="+fiboDynamic(n));
		duration = System.nanoTime() - start;
		System.out.println("fiboDynamic("+n+") took "+duration/1000000 +" milliseconds");
		System.out.println(Arrays.toString(fib2));
		
	}
	
	private static int fiboExponential(int index) {
		if (index == 0) {// base case
			fib[0] = 0;
			return 0;
		} else if (index == 1) {// base case
			fib[1] = 1;
			return 1;
		} else {// reduction and recursion
			// uncomment below to make Linear from Exponential
			//if(fib[index] != 0) return fib[index]; // check from cache
			
			fib[index] = fiboExponential(index -1) + fiboExponential(index -2);
			return fib[index];
		}
	}
	
	private static int fiboDynamic(int index){
		int f0 = 0; // for fib(0)
		int f1 = 1; // for fib(1)
		int f2 = 1; // for fib(2)
		if(index == 0) {
			fib2[0] = f0;
			return f0;
		}
		else if(index == 1) {
			fib2[0] = f0;
			fib2[1] = f1;
			return f1;
		}
		else if(index == 2) {
			fib2[0] =f0;
			fib2[1]=f1;
			fib2[2] = f2;
			return f2;
		}
		fib2[0] =f0;
		fib2[1]=f1;
		fib2[2] = f2;
		for(int i = 3; i <= index; i++){
			f0 = f1;
			f1 = f2;
			f2 = f0 + f1;
			fib2[i]= f2;
		}
		return f2;
	}
}
