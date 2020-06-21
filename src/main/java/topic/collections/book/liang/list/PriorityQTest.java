package topic.collections.book.liang.list;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQTest {
	public static void main(String[] args) {
		Queue<Integer> pq = new PriorityQueue<>();
		// natual ordering .. element with least value has highest priority
		testPQ(pq);
		pq = new PriorityQueue<>(Collections.reverseOrder());
		testPQ(pq);
	}
	
	public static void testPQ(Queue<Integer> pq){
		pq.add(1);
		pq.add(2);
		pq.add(3);
		pq.add(3);
		pq.add(3);
		pq.add(3);
		pq.add(4);
		pq.add(5);
		pq.add(6);
		
		System.out.println("Getting elements from PQ ..");
		while(pq.size() > 0){
			System.out.println(pq.remove() + " ");
		}
		
	}
}
