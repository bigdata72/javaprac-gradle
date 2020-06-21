package topic.algorithms.book.algs4ed.api;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Bag<Item> implements Iterable<Item> {
	private static final int DEFAULT_CAPACITY = 10;
	
	private Object[] EMPTY_CAPACITY = {};
	
	transient Object[] elementData;
	
	private int size;
	
	public Bag(){
		elementData = EMPTY_CAPACITY;
	}
	
	public boolean isEmpty(){
		return size() ==0 ;
	}
	
	public void add(Item e){
		ensureCapacityInternal(size + 1);
		elementData[size++] = e;
	}
	
	private void ensureCapacityInternal(int minCapacity){
		if(elementData == EMPTY_CAPACITY){
			minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
		}
		
		// when bag is full
		if(minCapacity - elementData.length >0){
			grow(minCapacity);
		}
	}
	
	private void grow(int minCapacity){
		int oldCapacity = elementData.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		if(newCapacity - minCapacity <0){
			newCapacity = minCapacity;
		}
		elementData = Arrays.copyOf(elementData, newCapacity);
	
	}
	
	
	public int size(){
		return size;
	}
	
	/**
	 * Returns an iterator over elements of type {@code T}.
	 *
	 * @return an Iterator.
	 */
	@NotNull
	@Override
	public Iterator<Item> iterator() {
		
		return new Itr();
	}
	
	
	private class Itr implements Iterator<Item>{
		private int cursor; // index of element to return
		private int lastRet =-1; // index of last element returned, -1 if no such
		
		/**
		 * Returns {@code true} if the iteration has more elements.
		 * (In other words, returns {@code true} if {@link #next} would
		 * return an element rather than throwing an exception.)
		 *
		 * @return {@code true} if the iteration has more elements
		 */
		@Override
		public boolean hasNext() {
			return cursor != size;
		}
		
		/**
		 * Returns the next element in the iteration.
		 *
		 * @return the next element in the iteration
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		@Override
		public Item next() {
			int i = cursor;
			// cursor at last element and next() called without calling hasNext()
			if(i >= size) throw new NoSuchElementException();
			Object[] elementData = Bag.this.elementData;
			if(i > elementData.length){
				throw new ConcurrentModificationException();
			}
			cursor = i+1; // increment the cursor
			// return the element just crossed
			return (Item) elementData[lastRet = i];
		}

	} // end inner class Itr
	
	public static void main(String[] args) {
		int capacity = 16;
		System.out.println(capacity >> 1);
	}
} // eof
