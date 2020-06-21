package topic.concurrency.book.corejava.blockingq;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingQueueTest {
	public static void main(String[] args) {
		String dir = "C:\\Users\\Arijit\\ideaprojects\\getajob";
		String keyword = "FutureTest";
		
		// queue size
		final int FILE_QUEUE_SIZE = 10;
		
		// search threads
		final int SEARCH_THREADS = 100;
		
		BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);
		FileEnumeratorTask enumerator = new FileEnumeratorTask(new File(dir), queue);
		Thread t1 = new Thread(enumerator);
		t1.start();
		
//		for(int i=0; i<SEARCH_THREADS; i++){
//			SearchTask searchTask = new SearchTask(keyword, queue);
//			Thread t = new Thread(searchTask);
//			t.start();
//		}
		SearchTask searchTask = new SearchTask(keyword, queue);
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		executorService.submit(searchTask);
		
		
		try{
			t1.join();
		}catch(InterruptedException ie){
			Thread.currentThread().interrupt();
		}
		
		System.out.println("done");
		executorService.shutdown();
	}
}

class FileEnumeratorTask implements Runnable{
	// input --> root dir, q to add
	// how to signal end of files
	private File directory;
	private BlockingQueue<File> q;
	public static File DUMMY = new File("");
	
	public FileEnumeratorTask(File dir, BlockingQueue<File> q){
		this.directory = dir;
		this.q = q;
	}
	
	
	@Override
	public void run() {
		try {
			enumerate(directory);
			q.put(DUMMY);
		}catch(InterruptedException ie){
		
		}
	}
	
	private void enumerate(File dir) throws InterruptedException{
		
		File [] files = dir.listFiles();
		for(File f : files){
			if(f.isDirectory()) enumerate(f);
			else {
				//System.out.printf("Added file %s%n", f.getName());
				q.put(f);
			}
		}
		
	}
}

class SearchTask implements Runnable{
	private BlockingQueue<File> queue;
	private String keyword;
	
	public SearchTask(String key, BlockingQueue<File> queue){
		this.keyword = key;
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try{
			boolean done = false;
			while(!done) {
				File file = queue.take();
				//System.out.printf(">>>Took file:%s%n", file.getName());
				if(file == FileEnumeratorTask.DUMMY){
					queue.put(file);
					done = true;
				}
				else search(file);
			}
		}
		catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
		catch(InterruptedException ie){
			Thread.currentThread().interrupt();
		}
	}
	
	private void search(File file) throws FileNotFoundException {
		try(Scanner in = new Scanner(file))
		{
			int lineNumber = 0;
			while(in.hasNextLine()){
				lineNumber ++;
				String line = in.nextLine();
				if(line.contains(keyword))
					System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
			}
		}
	}
}
