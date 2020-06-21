package topic.designpatterns.book.hfdp.be.iterator.example.menu;

public interface Iterator<E> {
	boolean hasNext();
	E next();
	E remove();
}
