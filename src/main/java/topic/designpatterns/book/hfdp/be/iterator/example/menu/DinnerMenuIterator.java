package topic.designpatterns.book.hfdp.be.iterator.example.menu;

import java.util.NoSuchElementException;

public class DinnerMenuIterator<E> implements Iterator<E>{
	E[] e;
	int cursor; // index of next element to return
	int lastRet = -1; // index of last element returned, -1 if no such
	public DinnerMenuIterator(E[] menu){
		this.e = menu;
	}
	
	@Override
	public boolean hasNext() {
		return cursor != e.length && e[cursor] != null;
	}
	
	@Override
	public E next() {
		if(cursor >= e.length) throw new NoSuchElementException();
		lastRet = cursor++;
		return e[lastRet];
	}
	
	@Override
	public E remove() {
		throw new UnsupportedOperationException("not implemented"); // TODO understand System.ArrayCopy
	}
}
