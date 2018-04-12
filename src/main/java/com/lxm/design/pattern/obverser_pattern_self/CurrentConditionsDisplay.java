package com.lxm.design.pattern.obverser_pattern_self;

public class CurrentConditionsDisplay implements Observer,DisplayElement{
	private float temperature;
	private float humidity;
	private Subject weatherData;
	
	public CurrentConditionsDisplay(Subject weatherData){
		this.weatherData=weatherData;
		this.weatherData.registerObserver(this);
	}
	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temperature=temp;
		this.humidity=humidity;
		this.display();
	}
	public void display(){
		System.out.println("current conditions:"+temperature+" F degrees and "+humidity+"% humidity");
	}

}
