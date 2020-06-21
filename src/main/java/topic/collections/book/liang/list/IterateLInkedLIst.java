package topic.collections.book.liang.list;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class IterateLInkedLIst {
	private static final int MAX_COUNT = 5000000;
	private static final int CONVERT_NANO_TO_SECOND = 1000000000;
	public static void main(String[] args) {
		// use Linked List with 5 million integers
		List<Integer> list = new LinkedList<>();
		populate(list, MAX_COUNT);
		//iterateGet(list);
		System.out.println("-----");
		iterateIterator(list);
	}
	
	// do not do this
	private static void iterateGet(List<Integer> list){
		// takes too long for 5 million integers .. exponential ?
		System.out.println("inside iterateGet() ...");
		long start = System.nanoTime();
		int count=1;
		for(int i=0; i<list.size();i++){ // do not do this. every time it starts from the begining
			list.get(i); // only optimization in get() is if i > size/2, search starts at end
			if(count % 100000 ==0) System.out.println(count);
			count++;
		}
		long duration = System.nanoTime() - start;
		System.out.println("Elapsed time in nanoseconds="+duration);
		System.out.println("Elapsed time in seconds ="+duration/CONVERT_NANO_TO_SECOND);
	}
	
	private static void iterateIterator(List<Integer> list){
		// takes 177 seconds for 5 million integers
		System.out.println("inside iterateIterator() ...");
		long start = System.nanoTime();
		int count = 1;
		for (int i: list) {
			System.out.println(count +") +"+i);
			count++;
		}
		long duration = System.nanoTime() - start;
		System.out.println("Elapsed time in nanoseconds="+duration);
		System.out.println("Elapsed time in seconds ="+duration/CONVERT_NANO_TO_SECOND);
	}
	
	
	
	private static void populate(List<Integer> list, int max){
		Random r = new Random(10000);
		for(int i=0; i<MAX_COUNT; i++){
			list.add(r.nextInt(MAX_COUNT) +1);
		}
		System.out.println(list.size());
	
	}
}
