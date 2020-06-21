package topic.concurrency.book.liang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
	public static void main(String[] args) {
		
		//ExecutorService executorService = Executors.newCachedThreadPool();
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		// submit runnable tasks
		executorService.execute(new PrintChar('a',100));
		executorService.execute(new PrintChar('b', 100));
		executorService.execute(new PrintNum(100));
		executorService.execute(new PrintChar('c', 100));
		
		executorService.shutdown();
		
		try{Thread.sleep(1000);}catch(InterruptedException ie){ie.printStackTrace();}
		
		System.out.println(executorService.isTerminated()); // returns true when all submitted tasks comple
		
		
	}
}
