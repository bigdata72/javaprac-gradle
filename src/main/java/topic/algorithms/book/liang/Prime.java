package topic.algorithms.book.liang;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Prime {
	public static void main(String[] args) {
		System.out.println("Input number");
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		System.out.println("Number entered="+number);
		
		// brute force algo
		// start from 2, increase by 1
		// divide each number by 2,3,4, ... sqrt(n)
		// if divisible then not prime else prime
		// increase count of prime
		// output prime numbers in line of 10 numbers each
		
		int count = 0;
		int NUM_OF_PRIMES_IN_ONE_LINE = 10;
		int n = 2;
		int upper = (int) sqrt(n);
		
		while(n <= number) {
			boolean isPrime = true;
			for (int i = 2; i <= (int)sqrt(n); i++) {
				if (n % i == 0 ) {
					isPrime = false;
					break;
				}
			}
			
			if (isPrime) {
				count++;
				if (count % NUM_OF_PRIMES_IN_ONE_LINE == 0)
					System.out.printf("%d%n", n);
				else
					System.out.printf("%d, ", n);
			}
			n++;
		}
		System.out.printf("%n %d primes less than or equal to %d", count, number);
	}
}
