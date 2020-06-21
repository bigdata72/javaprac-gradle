package topic.algorithms.book.algs4ed.ch1.bqs;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StackTest {
	
	@Test
	public void isEmpty() {
		Stack<String> stack = new Stack<>();
		assertThat(stack.isEmpty(), is(true));
		stack.push("to");
		assertThat(stack.isEmpty(), is(false));
	}
	
	@Test
	public void size() {
		Stack<String> stack = new Stack<>();
		assertThat(stack.size(), is(0));
		add(stack, "to", "be", "or", "not", "to", "be");
		assertThat(stack.size(), is(6));
	}
	
	@Test
	public void push() {
		Stack<String> stack = new Stack<>();
		add(stack, "to", "be");
		assertThat(stack.isEmpty(), is(false));
		assertThat(stack.size(), is(2));
	}
	
	@Test
	public void pop() {
		Stack<String> stack = new Stack<>();
		add(stack, "to", "be", "or", "not", "to", "be");
		remove(stack, 3);
		assertThat(stack.size(), is(3));
		remove(stack, 3);
		assertThat(stack.isEmpty(), is(true));
	}
	
	@Test
	public void hasNext(){
		Stack<String> stack = new Stack<>();
		Iterator<String> itr = stack.iterator();
		assertThat(itr.hasNext(), is(false));
		add(stack, "to", "be", "or", "not", "to", "be");
		itr = stack.iterator();
		assertThat(itr.hasNext(), is(true));
	}
	
	@Test
	public void next(){
		Stack<String> stack = new Stack<>();
		add(stack, "to", "be", "or", "not", "to", "be");
		Iterator<String> itr = stack.iterator();
		assertThat(itr.next(), is("be"));
		assertThat(itr.next(), is("to"));
		assertThat(itr.next(), is("not"));
		assertThat(itr.next(), is("or"));
		assertThat(itr.next(), is("be"));
		assertThat(itr.next(), is("to"));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void remove(){
		Stack<String> stack = new Stack<>();
		Iterator<String> itr = stack.iterator();
		itr.remove();
	}
	
	private void add(Stack<String> stack, String ... s){
		for(String str : s)
			stack.push(str);
	}
	
	private void remove(Stack<String> stack, int elements){
		for(int i=0; i<elements; i++){
			stack.pop();
		}
	}
}