package topic.algorithms.book.algs4ed.ch1.bqs;

import edu.princeton.cs.algs4.StdIn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FixedArrayStack<Item> {
	private static final Logger LOGGER = LoggerFactory.getLogger(FixedArrayStack.class);
	private int N;
	private Item[] item;
	
	public FixedArrayStack(int maxSize){
		item = (Item[])new Object[maxSize];
	}
	
	// stack methods
	public void push(Item e){
		if(N == item.length){
			throw new IllegalStateException("Stack is full");
		}
		item[N++] = e;
	}
	
	public Item pop(){
		Item obj = null;
		if(N == 0){
			LOGGER.info("Stack is empty");
		}else{
			obj = item[--N];
			item[N] = null;
		}
		return obj;
	}
	
	public int size(){
		return N;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public static void main(String[] args) {
		FixedArrayStack<String> stack = new FixedArrayStack<>(10);
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			if(!item.equals("-"))
				stack.push(item);
			else if(!stack.isEmpty()) {
				LOGGER.debug(stack.pop() +" ");
			}
		}
		LOGGER.debug(stack.size() +" items left on stack");
	}
	
}