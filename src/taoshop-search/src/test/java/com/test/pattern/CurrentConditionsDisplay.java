package com.test.pattern;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;

	Observable observable;

	public CurrentConditionsDisplay(Observable observable) {
//		weatherData.registerObserver(this);
		this.observable = observable;
		observable.addObserver(this);
	}

//	public void update(float temperature, float humidity, float pressure) {
//		this.temperature = temperature;
//		this.humidity = humidity;
//		display();
//	}

	/**
	 * This method is called whenever the observed object is changed. An
	 * application calls an <tt>Observable</tt> object's
	 * <code>notifyObservers</code> method to have all the object's
	 * observers notified of the change.
	 *
	 * @param o   the observable object.
	 * @param arg an argument passed to the <code>notifyObservers</code>
	 */
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof WeatherData){
			WeatherData wd = (WeatherData)o;
			temperature = wd.getTemperature();
			humidity = wd.getHumidity();
			display();
		}
	}

	public void display() {
		System.out.println("Current conditions: " + temperature
				+ "F degrees and " + humidity + "% humidity");
	}
}
