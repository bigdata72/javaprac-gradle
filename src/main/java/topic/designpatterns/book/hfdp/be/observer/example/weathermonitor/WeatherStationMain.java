package topic.designpatterns.book.hfdp.be.observer.example.weathermonitor;

import java.util.ArrayList;
import java.util.List;

public class WeatherStationMain {
	public static void main(String[] args) {
		CurrentWeather weather1 = new CurrentWeather(52.2, 45.7, 14);
		CurrentWeather weather2 = new CurrentWeather(77, 45.9, 16);
		CurrentWeather weather3 = new CurrentWeather(90.2, 35.7, 12);
		
		WeatherStation station = new WeatherStation();
		
		List<Display> displays = new ArrayList<>();
		
		// Create Current Conditions Display (1st display)
		CurrentConditionsDisplay current = new CurrentConditionsDisplay(station); // implements Observer
		
		// Create Statistics Display (2st display)
		StatisticsDisplay statistics = new StatisticsDisplay(station);
		
		displays.add(current);
		displays.add(statistics);
		
		// call display
		display(displays); // nothing to display yet, as no measurements
		
		System.out.println("Setting new weather data on Weather Station...");
		System.out.println();
		
		station.setCurrentWeather(weather1); // WeatherStation is a concrete Subject
		station.setCurrentWeather(weather2);
		station.setCurrentWeather(weather3);
		//now the observers should get notified
		
		// call the displays
		//display(displays);
		
	}
	
	private static void display(List<Display> devices){
		for (Display device : devices) {
			device.display();
		}
	}
}
