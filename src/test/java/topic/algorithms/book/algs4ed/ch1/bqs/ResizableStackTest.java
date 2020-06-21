package topic.algorithms.book.algs4ed.ch1.bqs;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ResizableStackTest {
	
	ResizableStack<Integer> stack;
	
	@Before
	public void setUp() throws Exception {
		stack = new ResizableStack<>();
	}
	
	@Test
	public void push() {
		add(17);
		assertThat(stack.size(), is(17));
		assertThat(stack.capacity(), is(32));
	}
	
	@Test
	public void pop() {
		add(8);
		remove(5);
		assertThat(stack.size(), is(3));
		assertThat(stack.capacity(), is(8));
	}
	
	@Test
	public void size() {
		assertThat(stack.size(), is(0));
		add(16);
		assertThat(stack.size(), is(16));
		add(1);
		assertThat(stack.capacity(), is(32));
		assertThat(stack.size(), is(17));
		add(15);
		assertThat(stack.size(), is(32));
		
	}
	
	@Test
	public void isEmpty() {
		assertThat(stack.isEmpty(), is(true));
		add(1);
		assertThat(stack.isEmpty(), is(false));
	}
	
	@Test
	public void testIteration(){
		add(4);
		int count = 4;
		for(int i : stack){
			assertThat(i, is(count--));
		}
	}
	
	private void add(int noOfItems){
		for(int i=1; i<= noOfItems; i++){
			stack.push(i);
		}
	}
	
	private void remove(int noOfItems){
		for(int i=1; i<= noOfItems; i++){
			stack.pop();
		}
	}
}