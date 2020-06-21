package topic.designpatterns.book.hfdp.be.observer.example.weathermonitor;

public class CurrentWeather implements WeatherData{
	private double temperature;
	private double humidity;
	private double pressure;
	
	public CurrentWeather(double temp, double h, double pr){
		this.temperature = temp;
		this.humidity = h;
		this.pressure = pr;
	}
	
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}
	
	@Override
	public double getTemperature() {
		return this.temperature;
	}
	
	@Override
	public double getHumidity() {
		return this.humidity;
	}
	
	@Override
	public double getPressure() {
		return this.pressure;
	}
}
