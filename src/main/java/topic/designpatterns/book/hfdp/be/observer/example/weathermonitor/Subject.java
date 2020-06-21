package topic.designpatterns.book.hfdp.be.observer.example.weathermonitor;

public interface Subject {
	public void register(Observer o);
	public void unregister(Observer o);
	public void notifyObservers();
}
