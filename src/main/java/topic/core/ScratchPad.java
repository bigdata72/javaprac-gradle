package topic.core;

import java.io.IOException;

public class ScratchPad {
	int val = 0;
	public int getVal() throws IOException {
		return val;
	}
	
	public void compute() throws RuntimeException{
		for(int i=0; i<10000; i++){
			if(i==100) throw new RuntimeException();
			if(i==101) System.out.println("101");
		}
	}
	
	public static void main(String[] args) {
		System.out.printf("Here we go");
		ScratchPad pad = new ScratchPad();
		RunnableOne one = new RunnableOne(pad);
		RunnableTwo two = new RunnableTwo(pad);
		Thread t1 = new Thread(one, "T1");
		Thread t2 = new Thread(two, "T2");
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		}catch(InterruptedException ie){
			System.out.println("IE");
		}
		long longVal = 123L;
		System.out.println("long:"+longVal); //long:123
		float floatVal = 123.45f;
		System.out.println("float:"+floatVal); //float:123.45
		floatVal = 1234L;
		System.out.println("float after explicit long value assignment, (floatVal = 1234L) :"+floatVal);
		//float after explicit long value assignment, (floatVal = 1234L) :1234.0
		
		floatVal = longVal;
		System.out.println("float after explicit long variable assignment, (floatVal = longVal) :"+floatVal);
		//float after explicit long variable assignment, (floatVal = longVal) :123.0
		
		long l = 12345678900L;
		float f = l;
		System.out.println("f="+f); //f=1.23456788E10
		System.out.println("(l-f) ="+(l-f)); //0.0
		System.out.println("(l - (long)f)="+ (l - (long)f)); //52 (loss of precision)
		
		
		int big = 1234567890;
		float approx = big;
		System.out.println("float approx ="+approx); //float approx =1.23456794E9
		System.out.println("big - approx="+(big - approx)); // 0.0
		System.out.println("big - (int) approx="+(big - (int) approx)); //-46 (loss of precision)
	}
}

class RunnableOne implements Runnable{
	private ScratchPad obj;
	
	public RunnableOne(ScratchPad o){
		this.obj = o;
	}
	
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " started ...");
			obj.compute();
			Thread.sleep(200);
		
		}catch(InterruptedException ie){
			Thread.currentThread().interrupt();
		}
	}
}

class RunnableTwo implements Runnable{
	private ScratchPad obj;
	
	public RunnableTwo(ScratchPad o){
		this.obj = o;
	}
	
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " started ...");
			Thread.sleep(100);
			obj.compute();
			Thread.sleep(100);
	
		}catch(InterruptedException ie){
			Thread.currentThread().interrupt();
		}
	}
}

