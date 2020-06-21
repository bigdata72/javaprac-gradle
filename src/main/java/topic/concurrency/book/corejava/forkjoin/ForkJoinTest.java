package topic.concurrency.book.corejava.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {
	public static void main(String[] args) {
		int size = 100000000;
		double [] arr = new double[size];
		
		for(int i=0; i<size; i++){
			arr[i] = Math.random();
		}
		//System.out.println(Arrays.toString(arr));
		
		Counter counter = new Counter(arr, 0, arr.length,
			new Filter(){
				
				@Override
				public boolean accept(double x) {
					return x > 0.5;
				}
			});
		
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(counter);
		System.out.println(counter.join());
	}
}

class Counter extends RecursiveTask<Integer>{
	private Filter f;
	private int from;
	private int to;
	private double [] values;
	private static final int THRESHOLD = 1000;
	
	public Counter(double[] values, int from, int to, Filter filter){
		this.f = filter;
		this.values = values;
		this.from = from;
		this.to = to;
	}
	
	@Override
	protected Integer compute() {
		if(to - from < THRESHOLD){
			int count = 0;
			for(int i=from; i<to; i++){
				if (f.accept(values[i])) count++;
			}
			return count;
		}else{
			int mid = (from + to)/2;
			
			Counter first = new Counter(values, from, mid, f);
			Counter second = new Counter(values, mid, to, f);
			invokeAll(first, second);
			return first.join() + second.join();
		}
		
	}
}

interface Filter{
	public boolean accept(double x);
}
