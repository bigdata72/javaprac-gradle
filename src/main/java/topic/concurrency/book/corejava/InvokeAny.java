package topic.concurrency.book.corejava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAny {
	public static void main(String[] args) {
		Compute callable1 = new Compute(10);
		Compute callable2 = new Compute(100000);
		Compute callable3 = new Compute(100005);
		List<Callable<Integer>> callables = new ArrayList<>();
		callables.add(callable1);
		callables.add(callable2);
		callables.add(callable3);
		
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		try {
			int result = service.invokeAny(callables);
			
			
			
			System.out.println("result ="+result);
		}catch(InterruptedException ie){
			Thread.currentThread().interrupt();
		}catch(ExecutionException ex){
			ex.printStackTrace();
		}
		service.shutdown();
	}
}

class Compute implements Callable<Integer>{
	private int value = 0;
	
	public Compute(int counter){
		this.value = counter;
	}
	
	private Integer compute(int n){
		int sum = 0;
		for(int i=0; i<n; i++){
			sum+=i;
		}
		System.out.printf("Sum of %d numbers is %d%n", n, sum);
		return sum;
	}
	
	@Override
	public Integer call() throws Exception {
		return compute(value);
	}
}
