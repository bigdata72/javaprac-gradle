package topic.designpatterns.book.hfdp.be.observer.example.weathermonitor;

public class CurrentConditionsDisplay extends Display {
	private Subject station;
	public CurrentConditionsDisplay(Subject station){
		this.station = station;
		station.register(this);
	}
	
	@Override
	public void display() {
		// get temp, humidity and pressure from WeatherData to display
		System.out.println("Current Conditions Display:");
		System.out.println("--------------------------");
		if(this.weather != null) {
			System.out.println("Temperature=" + weather.getTemperature());
			System.out.println("Humidity=" + weather.getHumidity());
			System.out.println("Pressure=" + weather.getPressure());
			System.out.println("--------------------------");
		}else{
			System.out.println("No weather data is available");
			System.out.println("--------------------------");
		}
	}
}
