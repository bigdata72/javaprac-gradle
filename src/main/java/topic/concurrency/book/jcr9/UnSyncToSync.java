package topic.concurrency.book.jcr9;

/**
 * Synchronize options:
 * 1) synchrnonize the method on target which is called with different states from diff threads
 * 2) synchronize on the target object from the caller run method
 */
public class UnSyncToSync {
	public static void main(String[] args) {
		System.out.println("Starting threads ...");
		CallMe callme = new CallMe();
		Caller one = new Caller(callme, "one", "Hello");
		Caller two = new Caller(callme, "two", "Sync");;
		Caller three = new Caller(callme, "three", "World");
		try{
			one.getT().join();
			two.getT().join();
			three.getT().join();
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println("Finished UnSyncToSync!");
	}
	
	/**
	 * Output (unsync):
	 Starting threads ...
	 [Sync[Hello[World]
	 ]
	 ]
	 Finished !
	 * ---------------
	 * Output (sync) :
	 Starting threads ...
	 [Hello]
	 [World]
	 [Sync]
	 Finished UnSyncToSync!
	 */
}

class CallMe{

	void call(String msg){ // add synchrnonized to method signature to make it thread safe
		System.out.print("[" + msg);
		try{
			Thread.sleep(1000);
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println("]");
	}
}

class Caller implements Runnable{
	private CallMe target;
	private String name;
	private String msg;
	private Thread t;
	
	Caller(CallMe target, String name, String msg){
		this.target = target;
		this.msg = msg;
		this.name = name;
		t = new Thread(this, name);
		t.start();
	}
	
	@Override
	public void run() {
		// also you can synchronize on the target object to make thread safe
		synchronized (target) {
			target.call(msg);
		}
	}
	
	public Thread getT(){return this.t;}
}
