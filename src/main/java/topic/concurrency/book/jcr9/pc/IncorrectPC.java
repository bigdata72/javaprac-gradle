package topic.concurrency.book.jcr9.pc;

/**
 * Incorrect PC behavior, wasted cycles, overruns
 */
public class IncorrectPC {
	public static void main(String[] args) {
		// create a producer, consumer and a queue
		Q q = new Q();
		Producer p = new Producer(q);
		Consumer c = new Consumer(q);
		Thread one = new Thread(p, "producer");
		Thread two = new Thread(c, "consumer");
		one.start();
		two.start();
		
		try{
			one.join();
			two.join();
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}
}

class Q {
	int i;
	
	synchronized int get(){
		System.out.println("Got :"+i);
		return i;
	}
	
	synchronized void put(int i){
		this.i = i;
		System.out.println("Put :"+i);
	}
}

class Producer implements Runnable{
	Q q;
	int i;
	
	Producer(Q q){
		this.q = q;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				q.put(i++);
				Thread.sleep(1000);
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable{
	Q q;
	Consumer(Q q){
		this.q = q;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				q.get();
				Thread.sleep(1500);
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
	}
}
