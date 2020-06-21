package topic.concurrency;

import javax.annotation.concurrent.GuardedBy;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CMETest {
	private final static int SIZE = 1000000;
	public static void main(String[] args) {
		
		// create HiddenIterator
		HiddenIterator iter = new HiddenIterator(SIZE);
		
		// Create a Runnable
		RunnableOne one = new RunnableOne(iter);
		RunnableTwo two = new RunnableTwo(iter);
		
		// spawn two threads
		Thread th1 = new Thread(one, "ThreadOne");
		Thread th2 = new Thread(two, "ThreadTwo");
		th1.start();
		th2.start();
	}
}

class HiddenIterator{
	@GuardedBy("this")
	private final Set<Integer> set = new HashSet<>();
	
	@GuardedBy("this")
	private final int count;
	
	public HiddenIterator(int count){
		this.count = count;
	}
	
	public synchronized void add(Integer i){set.add(i);};
	
	public void addThings(){
		System.out.println(Thread.currentThread().getName()+" started addThings()..");
		Random r = new Random();
		for(int i=0; i<count; i++) {
			add(r.nextInt());
		}
		System.out.println(Thread.currentThread().getName()+"-DEBUG1: Added "+count+" elements to :"+set);
		System.out.println(Thread.currentThread().getName()+"-SENTINEL");
	}
	
	public void print(){
		System.out.println(Thread.currentThread().getName()+":");
		System.out.println("print: Added "+count+" elements to :"+set);
	}
}

class RunnableOne implements Runnable{
	private HiddenIterator itr;
	
	public RunnableOne(HiddenIterator iterator){
		this.itr = iterator;
	}
	
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " started ...");
			itr.addThings();
			Thread.sleep(200);
			//itr.print();
		}catch(InterruptedException ie){
			Thread.currentThread().interrupt();
		}
	}
}

class RunnableTwo implements Runnable{
	private HiddenIterator itr;
	
	public RunnableTwo(HiddenIterator iterator){
		this.itr = iterator;
	}
	
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " started ...");
			Thread.sleep(100);
			itr.addThings();
			Thread.sleep(100);
			//itr.print();
		}catch(InterruptedException ie){
			Thread.currentThread().interrupt();
		}
	}
}
