package topic.designpatterns.book.hfdp.be.observer.example.weathermonitor;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject{
	private List<Observer> observers;
	private CurrentWeather weather;
	
	public void setCurrentWeather(CurrentWeather w){
		this.weather = w;
		measurementChanged();
	}
	
	public WeatherStation(){
		observers = new ArrayList<>();
	}
	
	public boolean measurementChanged(){
		notifyObservers();
		return true;
	}
	
	
	@Override
	public void register(Observer o) {
		if(o != null)
			observers.add(o);
	}
	
	@Override
	public void unregister(Observer o) {
		if(o != null && observers.indexOf(o) >=0)
			observers.remove(o);
	}
	
	@Override
	public void notifyObservers() {
		System.out.println("New weather data available .. notify all observers");
		for (Observer o: observers) {
			o.update(this.weather);
		}
		
	}
}
