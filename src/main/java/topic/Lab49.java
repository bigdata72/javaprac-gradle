package topic;

import java.util.Arrays;
import java.util.List;

public class Lab49 {
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList(null, "a", "b");
		for(String s : list){
			System.out.println(s);
		}
		Thread t = new Thread(){
			@Override
			public void run(){
				System.out.println("child thread");
			}
		};
		t.start();
		System.out.println("Main thread");
		
	
		
	}
}
