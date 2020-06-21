package topic.collections.book.dscollins.ll;

import java.util.*;

public class SingleLinkedList<E> extends AbstractCollection<E> implements List<E> {
	
	protected Entry<E> head;
	
	SingleLinkedList(){ head = null;}
	
	@Override
	public boolean isEmpty(){
		
		return head == null;
	}
	
	public void addToFront(E element){
		Entry<E> newEntry = new Entry<>();
		newEntry.element = element;
		newEntry.next = head;   // the new entry points to the old head
		head = newEntry;		// the new element becomes the head now
	}
	
	@Override
	public int size() {
		int count = 0;
		for(Entry<E> current = head; current != null; current = current.next){
			count++;
		}
		return count;
	}
	
	public boolean contains(Object obj){
		if(obj == null){
			for(Entry<E> current = head; current != null; current = current.next){
				if(obj == current.element)
					return true;
			}
		}
		else{
			for(Entry<E> current = head; current != null; current = current.next){
				if(obj.equals(current.element))
					return true;
			}
		}
		return false;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new Itr();
	}
	
	protected class Itr implements Iterator<E>{
		protected Entry<E> next;
		
		protected Itr(){
			next = head;
		}
		
		@Override
		public boolean hasNext() {
			return next != null;
		}
		
		@Override
		public E next() {
			E result = next.element; // the element it crossed over
			next = next.next; // point to the next link
			return result;
		}
	}
	
	protected class Entry<E>{
		protected E element;
		protected Entry<E> next;
		
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return false;
	}
	
	@Override
	public E get(int index) {
		return null;
	}
	
	@Override
	public E set(int index, E element) {
		return null;
	}
	
	@Override
	public void add(int index, E element) {
	
	}
	
	@Override
	public E remove(int index) {
		return null;
	}
	
	@Override
	public int indexOf(Object o) {
		return 0;
	}
	
	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}
	
	@Override
	public ListIterator<E> listIterator() {
		return null;
	}
	
	@Override
	public ListIterator<E> listIterator(int index) {
		return null;
	}
	
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return null;
	}
	
	
	
}


