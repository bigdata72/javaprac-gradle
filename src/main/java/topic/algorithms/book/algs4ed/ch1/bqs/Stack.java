package topic.algorithms.book.algs4ed.ch1.bqs;

import org.jetbrains.annotations.NotNull;
import java.util.Iterator;

public class Stack<Item> implements Iterable{
	private Node first;
	private int N;
	
	@NotNull
	@Override
	public java.util.Iterator<Item> iterator() {
		return new ReverseIterator();
	}
	
	private class Node{
		Item item;
		Node next;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return N;
	}
	
	public void push(Item e){
		Node oldFirst = first;
		first = new Node();
		first.item = e;
		first.next = oldFirst;
		N++;
	}
	
	public Item pop(){
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	class ReverseIterator implements Iterator<Item>{
		private Node index = first;
		
		@Override
		public boolean hasNext() {
			return index != null;
		}
		
		@Override
		public Item next() {
			Item item = index.item;
			index = index.next;
			return item;
		}
		
		@Override
		public void remove(){
			throw new UnsupportedOperationException("not supported");
		}
		
		
	} // ReverseIterator
}
