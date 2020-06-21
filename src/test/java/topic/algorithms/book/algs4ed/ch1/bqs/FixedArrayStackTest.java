package topic.algorithms.book.algs4ed.ch1.bqs;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class FixedArrayStackTest {
	
	@Test
	public void push() {
		FixedArrayStack<String> stack = new FixedArrayStack<>(5);
		stack.push("to");
		stack.push("be");
		stack.push("or");
		assertThat(stack.pop(), is("or"));
		assertThat(stack.pop(), is("be"));
		assertThat(stack.pop(), is("to"));
		
	}
	
	@Test
	public void pop() {
		FixedArrayStack<String> stack = new FixedArrayStack<>(1);
		assertThat(stack.pop(), is(nullValue()));
		stack.push("one");
		assertThat(stack.pop(), is("one"));
	}
	
	@Test(expected = IllegalStateException.class)
	public void pushOverCapacity(){
		FixedArrayStack<String> stack = new FixedArrayStack<>(0);
		stack.push("full");
	}
	
	@Test
	public void size() {
		FixedArrayStack<Integer> stack = new FixedArrayStack<>(5);
		assertThat(stack.size(), is(0));
		stack.push(1);
		stack.push(2);
		assertThat(stack.size(), is(2));
		stack.pop();
		assertThat(stack.size(), is(1));
	}
	
	@Test
	public void isEmpty() {
		FixedArrayStack<Integer> stack = new FixedArrayStack<>(5);
		assertThat(stack.isEmpty(), is(true));
		stack.push(1);
		assertThat(stack.isEmpty(), is(false));
		stack.pop();
		assertThat(stack.isEmpty(), is(true));
	}
}