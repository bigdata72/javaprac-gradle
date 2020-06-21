package topic.concurrency;

import javax.annotation.concurrent.GuardedBy;

import static java.lang.Thread.sleep;

public class ThreadExample implements Runnable {
	@GuardedBy("this")
	
	@Override
	public void run() {
		int count = 0;
		System.out.println(Thread.currentThread().getName() + " started ..");
		while (count <= 10) {
				System.out.println(Thread.currentThread().getName() + " woke up, count again ..");
				System.out.println(Thread.currentThread().getName() + " count=" + count);
				try {
					System.out.println(Thread.currentThread().getName()+" going to sleep");
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (count == 10)
					System.out.println(">>>>  " + Thread.currentThread().getName() + " finished counting");
				count++;
		}
		System.out.println(Thread.currentThread().getName() +" ending ");
	}
	/**
			1. Start two threads. print their names
	 **/
	public static void main(String[] args) {
		ThreadExample instance = new ThreadExample();
		Thread thread1 = new Thread(instance, "Thread1");
		Thread thread2 = new Thread(instance, "Thread2");
		thread2.setPriority(Thread.MAX_PRIORITY);
		thread1.setPriority(Thread.MIN_PRIORITY);
		thread1.start();
		thread2.start();
	}
	
}
