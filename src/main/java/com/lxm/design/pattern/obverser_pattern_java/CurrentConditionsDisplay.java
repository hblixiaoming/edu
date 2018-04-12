package com.lxm.design.pattern.obverser_pattern_java;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer,DisplayElement{
	Observable observable;
	private float temperature;
	private float humidity;
	
	public CurrentConditionsDisplay(Observable observable){
		this.observable=observable;
		observable.addObserver(this);
	}
	@Override
	public void display(){
		System.out.println("Current conditions:"+temperature+"Current humidity:"+humidity);
	}

	@Override
	public void update(Observable obs, Object args) {
		if(obs instanceof WeatherData){
			WeatherData weatherData=(WeatherData)obs;
			this.temperature=weatherData.getTemperature();
			this.humidity=weatherData.getHumidity();
			display();
		}
	}
	
}
