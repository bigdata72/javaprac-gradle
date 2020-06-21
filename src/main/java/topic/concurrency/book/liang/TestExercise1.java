package topic.concurrency.book.liang;

public class TestExercise1 implements Runnable {
	
	public TestExercise1(){
		Thread t = new Thread(this);
		t.start();
		
	}
	
	private void init(){
	
	}
	@Override
	public void run() {
		System.out.println("test");
	}
	
	public static void main(String[] args) {
		new TestExercise1();
	}
}
