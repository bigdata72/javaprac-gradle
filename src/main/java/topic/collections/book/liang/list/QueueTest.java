package topic.collections.book.liang.list;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
		System.out.println("With ArrayDeque ...");
		Queue<Integer> q1 = new ArrayDeque<>();
		testQueueWithNullElements(q1);
		// now use a LinkedList
		System.out.println("With LinkedList ...");
		q1 = new LinkedList<>();
		testQueueWithNullElements(q1);
	}
	
	public static void testQueueWithNullElements(Queue<Integer> q){
		try {
			q.offer(null); //does not allow null
		}catch(NullPointerException npe){
			System.out.println(npe.getClass());
		}
		q.offer(1);
		q.offer(2);
		q.offer(3);
		System.out.println("q.poll() returns:"+q.poll());
		System.out.println("q.element():"+q.element());
		
		Queue<Integer> q2 = new ArrayDeque<>();
		q2.offer(1);
		q2.offer(2);
		q2.offer(3);
		System.out.println("checking queue element based equality"+ q.equals(q2));
		while(q.size() > 0){
			System.out.println(q.remove() + " ");
		}
		
	}
}
