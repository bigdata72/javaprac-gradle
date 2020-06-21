package topic.algorithms.book.algs4ed.ch1.bqs;

import topic.algorithms.book.algs4ed.api.Bag;
import edu.princeton.cs.algs4.StdIn;


// a typical bag client
public class Stats {
	public static void main(String[] args) {
		// demonstrate use of Bags
		Bag<Double> numbers = new Bag<>();
		while(!StdIn.isEmpty()){
			numbers.add(StdIn.readDouble());
		}
		
		System.out.println("Is bag empty?"+numbers.isEmpty());
		System.out.println("Size of Bag="+numbers.size());
		for(double d:numbers){
			System.out.println(d);
		}
		
		// calculate mean
		double sum = 0.0;
		int N = numbers.size();
		for(double d: numbers){
			sum+=d;
		}
		double mean = sum/N;
		// format specifier follows the syntax :
		// %[argument_index$][flags][width][.precision]conversion
		System.out.format("Mean = %1$.2f",mean);
		System.out.println();
		
		// calculate SD
		sum = 0.0;
		for(double d : numbers){
			sum+=(d-mean)*(d-mean);
		}
		System.out.println("(d-mean) square="+sum);
		double sd = Math.sqrt(sum/N);
		System.out.format("SD = %1$.3f", sd);
	
	
		
		
	}
	
}
