package topic.concurrency.book.corejava.callablefuture;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class FutureTest {
	public static void main(String[] args) {
		String dir = "C:\\Users\\Arijit\\ideaprojects\\getajob";
		String keyword = "FutureTest";
		
		ExecutorService pool = Executors.newCachedThreadPool();
		//usingFutureTask(dir, keyword);
		usingExecutors(dir, keyword, pool);
	}
	
	private static void usingFutureTask(String dir, String keyword) {
		MatchCounter counter = new MatchCounter(new File(dir), keyword);
		FutureTask<Integer> task = new FutureTask<>(counter);
		Thread t = new Thread(task);
		t.start();
		try{
			System.out.printf("Result is %d%n", task.get());
		}catch(ExecutionException ie){
			ie.printStackTrace();
		}catch(InterruptedException ie){
			Thread.currentThread().interrupt();
		}
	}
	
	private static void usingExecutors(String dir, String keyword, ExecutorService pool){
		MatchCounter counter = new MatchCounter(new File(dir), keyword, pool);
		Future<Integer> result = pool.submit(counter);
		try{
			System.out.printf("Result is %d%n", result.get());
		}catch(ExecutionException ie){
			ie.printStackTrace();
		}catch(InterruptedException ie){
			Thread.currentThread().interrupt();
		}
		pool.shutdown();
		int largestPoolSize = ((ThreadPoolExecutor)pool).getLargestPoolSize();
		System.out.println("Largest pool size ="+largestPoolSize);
	}
}

class MatchCounter implements Callable<Integer>{
	private File directory;
	private String keyWord;
	private ExecutorService pool;
	
	public MatchCounter(File directory, String keyword){
		this.directory = directory;
		this.keyWord = keyword;
	}
	
	public MatchCounter(File directory, String keyword, ExecutorService aPool){
		this.directory = directory;
		this.keyWord = keyword;
		this.pool = aPool;
	}
	
	@Override
	public Integer call() throws Exception {
		int count = 0;
		try{
			File[] files = directory.listFiles();
			List<Future<Integer>> results = new ArrayList<>();
			
			for(File file : files){
				if(file.isDirectory()){
					//usingFutureTask(results, file);
					usingExecutors(results, file, pool);
				}else{
					if(search(file)) count++;
				}
			}
			
			for(Future<Integer> result : results){
				try{
					count += result.get();
				}catch(ExecutionException ee){
					ee.printStackTrace();
				}
			}
			
		}catch(InterruptedException ie){
			Thread.currentThread().interrupt();
		}
		return count;
	}
	
	private void usingFutureTask(List<Future<Integer>> results, File file) {
		MatchCounter counter = new MatchCounter(file, keyWord);
		FutureTask<Integer> task = new FutureTask<>(counter);
		results.add(task);
		Thread thread = new Thread(task);
		thread.start();
	}
	
	private void usingExecutors(List<Future<Integer>> results, File file, ExecutorService pool){
		MatchCounter counter = new MatchCounter(file, keyWord, pool);
		Future<Integer> result = pool.submit(counter);
		results.add(result);
		
	}
	
	private boolean search(File file){
		try{
			try(Scanner scanner = new Scanner(file))
			{
				boolean found = false;
				while(! found && scanner.hasNextLine()){
					String line = scanner.nextLine();
					if(line.contains(keyWord)) found = true;
				}
				return found;
			}
		}catch(IOException ioe){
			return false;
		}
	}
}
