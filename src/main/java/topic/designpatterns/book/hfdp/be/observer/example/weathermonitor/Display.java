package topic.designpatterns.book.hfdp.be.observer.example.weathermonitor;

public abstract class Display implements Observer{
	
	protected CurrentWeather weather;
	
	@Override
	public void update(CurrentWeather weather) {
		this.weather = weather;
		display();
	}
	
	public abstract void display();
}
