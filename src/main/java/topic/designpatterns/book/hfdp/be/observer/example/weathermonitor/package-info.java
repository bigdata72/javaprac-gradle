/**
 * WeatherData class gives readings for temp, humidity and pressure
 * also measurementChanged() gets called whenever any of the above attributes changes
 *
 * DisplayConditions needs to talk to WeatherData and update readings.
 * CurrentConditions is one Display device which shows Temp, Humidity and Pressure
 * Statistics and Forecast can be future display devices.
 * New display devices should be possible to integrate with the design and api
 */
package topic.designpatterns.book.hfdp.be.observer.example.weathermonitor;