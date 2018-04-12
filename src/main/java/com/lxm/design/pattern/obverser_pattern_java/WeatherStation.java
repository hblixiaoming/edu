package com.lxm.design.pattern.obverser_pattern_java;

public class WeatherStation {
	public static void main(String[] args){
		WeatherData weatherData=new WeatherData();
		CurrentConditionsDisplay display=new CurrentConditionsDisplay(weatherData);
		weatherData.setMeasurements(3.4f, 3.5f,3.6f);
		
		weatherData.setMeasurements(4.4f, 4.5f,4.6f);
	}
}
