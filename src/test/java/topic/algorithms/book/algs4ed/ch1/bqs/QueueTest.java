package topic.algorithms.book.algs4ed.ch1.bqs;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class QueueTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(QueueTest.class);
	
	@Test
	public void isEmpty() {
		Queue<Integer> queue = new Queue<>();
		assertThat(queue.isEmpty(), is(true));
		queue.offer(1);
		assertThat(queue.isEmpty(), is(false));
	}
	
	@Test
	public void size() {
		Queue<Integer> queue = new Queue<>();
		assertThat(queue.size(), is(0));
		queue.offer(1);
		assertThat(queue.size(), is(1));
	}
	
	@Test
	public void offer() {
		Queue<Integer> queue = new Queue<>();
		queue.offer(1);
		assertThat(queue.size(), is(1));
		
	}
	
	@Test
	public void poll() {
		Queue<Integer> queue = new Queue<>();
		enqueue(queue, 1,2,3);
		Integer result = queue.poll();
		assertThat(result, is(1));
		assertThat(queue.size(), is(2));
		
		result = queue.poll();
		assertThat(result, is(2));
		assertThat(queue.size(), is(1));
		
		result = queue.poll();
		assertThat(result, is(3));
		assertThat(queue.size(), is(0));
		assertThat(queue.isEmpty(), is(true));
		
		// empty queue now
		result = queue.poll();
		assertThat(result, is(nullValue()));
	
	}
	
	private void enqueue(Queue<Integer> q, int ... N){
		for(int num : N){
			q.offer(num);
		}
	}
}