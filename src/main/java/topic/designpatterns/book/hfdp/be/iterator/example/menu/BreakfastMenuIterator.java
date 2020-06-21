package topic.designpatterns.book.hfdp.be.iterator.example.menu;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BreakfastMenuIterator<E> implements Iterator<E> {
	ArrayList<E> menuItems;
	int cursor;
	int lastRet = -1;
	
	public BreakfastMenuIterator(ArrayList<E> menuItems){
		this.menuItems = menuItems;
	}
	
	@Override
	public boolean hasNext() {
		return cursor != menuItems.size();
	}
	
	@Override
	public E next() {
		int i = cursor;
		if(i >= menuItems.size()) throw new NoSuchElementException();
		cursor = i + 1;
		return menuItems.get(lastRet = i);
	}
	
	@Override
	public E remove() {
		throw new UnsupportedOperationException();
	}
}
