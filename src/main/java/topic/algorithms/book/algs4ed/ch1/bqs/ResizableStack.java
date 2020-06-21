package topic.algorithms.book.algs4ed.ch1.bqs;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizableStack<Item> implements Iterable<Item>{
	private Item[] item;
	private int N;
	private static final int MAX_SIZE = 16;
	
	ResizableStack(){
		item = (Item[])new Object[MAX_SIZE];
	}
	
	public void push(Item e){
		// check for size
		if(N == item.length) {
			resize(N << 1); // double
		}
		item[ N++ ] = e;
	}
	
	public Item pop(){
		Item obj = item[--N];
		item[N] = null;
		if(N==0) {
			// empty stack
		}else if(N >0 && N == item.length/4){
			resize(item.length >> 1);
		}
		return obj;
	}
	
	public int size(){
		return N;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	private void resize(int maxSize){
		Item[] arr = (Item[])new Object[maxSize];
		for(int i=0; i<N; i++){
			arr[i] = item[i];
		}
		item = arr;
	}
	
	public int capacity(){
		return item.length;
	}
	
	@NotNull
	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item>{
		private int i = N;
		@Override
		public boolean hasNext() {
			return i > 0;
		}
		
		@Override
		public Item next() {
			if(i == 0) throw new NoSuchElementException();
			return item[--i];
		}
		
		@Override
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}
	
}


