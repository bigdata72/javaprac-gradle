package topic.collections.book.liang.list;

public interface MyList<E> extends Iterable<E>{
	E get(int index);
	int indexOf(E e);
	int lastIndexOf(E e);
	boolean add(E e);
	boolean add(int index, E e);
	int size();
	boolean isEmpty();
	boolean remove(E e);
	E remove(int index);
	E set(int index, E e);
	void clear();
	boolean contains(E e);
}
