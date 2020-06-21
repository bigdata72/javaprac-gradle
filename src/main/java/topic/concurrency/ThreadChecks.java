package topic.concurrency;

import java.util.Hashtable;
import java.util.Map;

public class ThreadChecks {
	public static void main(String[] args) {
		System.out.printf("Available processors = %d", Runtime.getRuntime().availableProcessors()); //4
		hashTableConcurrentUpdates();
	}
	
	public static void hashTableConcurrentUpdates(){
		Map<Integer, String> map = new Hashtable<>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		MyRunnable r1 = new MyRunnable(map);
		MyRunnable2 r2 = new MyRunnable2(map);
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		}catch(InterruptedException ie){
			Thread.currentThread().interrupt();
		}
		System.out.println(map);
		
	}
}

class MyRunnable implements Runnable{
	private Map<Integer, String> objMap;
	
	public MyRunnable(Map<Integer, String> aMap){
		this.objMap = aMap;
	}
	
	@Override
	public void run() {
		try{
			objMap.put(5, "E");
			Thread.sleep(1000);
			objMap.put(6, "F");
			Thread.sleep(1000);
			objMap.put(7, "G");
			Thread.sleep(1000);
			objMap.put(8, "H");
			System.out.println("Done 1");
			
		}catch(InterruptedException ie){
		
		}
		
	}
}

class MyRunnable2 implements Runnable{
	private Map<Integer, String> objMap;
	
	public MyRunnable2(Map<Integer, String> aMap){
		this.objMap = aMap;
	}
	
	@Override
	public void run() {
		try{
			objMap.put(5, "F");
			Thread.sleep(1000);
			objMap.put(6, "G");
			Thread.sleep(1000);
			objMap.put(7, "H");
			Thread.sleep(1000);
			objMap.put(8, "I");
			System.out.println("Done 2");
			
		}catch(InterruptedException ie){
		
		}
		
	}
}
