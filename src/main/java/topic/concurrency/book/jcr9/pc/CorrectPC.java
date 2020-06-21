package topic.concurrency.book.jcr9.pc;

public class CorrectPC {
	public static void main(String[] args) {
		// create a producer, consumer and a queue
		System.out.println("started ...");
		Q2 q2 = new Q2();
		Producer2 p2 = new Producer2(q2);
		Consumer2 c2 = new Consumer2(q2);
		Thread one = new Thread(p2, "producer 1");
		Thread two = new Thread(c2, "consumer 1");
		Thread three = new Thread(c2, "consumer 2");
		one.start();
		two.start();
		three.start();
		
		try{
			one.join();
			two.join();
			three.join();
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println("Program complete !");
	}
}

class Q2 {
	int i;
	boolean valueSet;
	
	synchronized int get(){
		while(!valueSet)
		try {
			wait();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+ " Got :" + i);
		valueSet = false;
		notify();
		return i;
	}
	
	synchronized void put(int i){
		while(valueSet)
		try {
			wait();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		this.i = i;
		System.out.println(Thread.currentThread().getName() + " put :" + i);
		valueSet = true;
		notify();
	}
}

class Producer2 implements Runnable{
	Q2 q2;
	int i;
	
	Producer2(Q2 q2){
		this.q2 = q2;
	}
	
	@Override
	public void run() {
		while(i <= 10) {
			try {
				q2.put(i++);
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() +" is done");
	}
}

class Consumer2 implements Runnable{
	Q2 q2;
	Consumer2(Q2 q2){
		this.q2 = q2;
	}
	int count = 0;
	
	@Override
	public void run() {
		while(count <=10) {
			try {
				count = q2.get();
				Thread.sleep(10);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " is done");
	}
}

