package com.lxm.design.pattern.obverser_pattern_self;

public class WeatherStation {
	public static void main(String[] args){
		WeatherData weatherData=new WeatherData();
		CurrentConditionsDisplay display=new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay display1=new StatisticsDisplay(weatherData);
		weatherData.setMeasurements(3.4f, 3.5f,3.6f);
		
		weatherData.setMeasurements(4.4f, 4.5f,4.6f);
	}
}
