package topic.concurrency.book.corejava;

public class UncaughtExceptionHandler {
	public static void main(String[] args) {
		MyRunnable runnable = new MyRunnable();
		MyThreadExceptionHandler handler = new MyThreadExceptionHandler();
		Thread th = new Thread(runnable, "Thread 1");
		Thread.setDefaultUncaughtExceptionHandler(handler); // default handler for all threads
		//th.setUncaughtExceptionHandler(handler);
		th.start();
		try {
			Thread.currentThread().sleep(1000);
		}catch(InterruptedException ie){
			Thread.currentThread().interrupt();
		}
		th.interrupt();
	}
	
}

class MyRunnable implements Runnable{
	
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			System.out.println("No interruptions... running away ...");
		}
		System.out.println("Got interrupted");
		int count = 0;
		for(int i=0; i< Integer.MAX_VALUE; i++){
			count++;
			System.out.println(count +") doing important compute ...");
			if(count == 20) throw new RuntimeException("some runtime exception");
		}
	}
}

class MyThreadExceptionHandler implements Thread.UncaughtExceptionHandler{
	
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("No escaping ... i am the Uncaught Thread exception handler ..");
		System.out.println("Thread Name which caused Runtime Exception = "+t.getName());
		System.out.println("The exception message was :"+e.getMessage());
		
	}
}
