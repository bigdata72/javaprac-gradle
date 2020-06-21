package topic.concurrency.book.jcr9;

/**
 * program to demonstrate concept of join() and isAlive()
 * isAlive() returns true if thread is running
 * join() use to wait for a thread to finish
 */
public class ThreadDemoJoin {
	public static void main(String[] args) {
		MyThread one = new MyThread("one");
		MyThread two = new MyThread("two");
		MyThread three = new MyThread("three");
		System.out.println("Thread one is alive ? "+ one.t.isAlive());
		System.out.println("Thread two is alive ? "+ two.t.isAlive());
		System.out.println("Thread three is alive ? "+ three.t.isAlive());
		
		System.out.println(">> Waiting for threads to finish ...");
		try{
			one.t.join();
			two.t.join();
			three.t.join();
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		
		System.out.println("Thread one is alive ? "+ one.t.isAlive());
		System.out.println("Thread two is alive ? "+ two.t.isAlive());
		System.out.println("Thread three is alive ? "+ three.t.isAlive());
		
		System.out.println(Thread.currentThread().getName());
	}
}

class MyThread implements Runnable{
	Thread t;
	MyThread(String name){
		t = new Thread(this, name);
		System.out.println("New Thread:"+t);
		t.start();
	}
	
	@Override
	public void run() {
		for(int i=1; i<=5;i++){
			System.out.println(t.getName()+":"+i);
		}
		System.out.println(t.getName()+" exiting ..");
	}
}
