package topic.designpatterns.book.hfdp.be.observer.example.weathermonitor;

public class StatisticsDisplay extends Display{
	
	private double totalTemp;
	private double totalHumidity;
	private double totalPressure;
	private int count;
	private Subject weatherStation;
	
	public StatisticsDisplay(Subject weatherStation){
		this.weatherStation = weatherStation;
		weatherStation.register(this);
	}
	
	@Override
	public void display(){
		// get temp, humidity and pressure from WeatherData to display
		System.out.println("Statistics Display:");
		System.out.println("--------------------------");
		
		System.out.println("Average Temperature=" + computeAvgTemp());
		System.out.println("Average Humidity=" + computeAvgHumidity());
		System.out.println("Pressure=" + computeAvgPressure());
		System.out.println("--------------------------");
	}
	
	private double computeAvgTemp(){
		if(totalTemp !=0)
			return totalTemp/count;
		else
			return totalTemp;
	}
	private double computeAvgHumidity(){
		if(totalHumidity !=0)
			return totalHumidity/count;
		else
			return totalHumidity;
	}
	private double computeAvgPressure(){
		if(totalPressure !=0)
			return totalPressure/count;
		else
			return totalPressure;
	}
	
	@Override
	public void update(CurrentWeather weather) {
		if(weather != null) {
			count++;
			totalTemp += weather.getTemperature();
			totalHumidity += weather.getHumidity();
			totalPressure += weather.getPressure();
		}
		display();
	}
}
