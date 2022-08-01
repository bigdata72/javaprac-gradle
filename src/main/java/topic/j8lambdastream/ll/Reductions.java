package topic.j8lambdastream.ll;

import java.util.Arrays;
import java.util.Collection;

public class Reductions {
	public static void main(String[] args) {
		Collection<String> words = Arrays.asList("learning", "functional-programiing", "using", "lambdas", "and",
		"streams");
		String allWords = words.stream()
										.reduce("", (a,b) -> a + " " + b);
		System.out.println(allWords);
		
	}
	
//	static <T> T reduce(T seed, BinaryOperator<T> accumulator){
//
//	}
}
