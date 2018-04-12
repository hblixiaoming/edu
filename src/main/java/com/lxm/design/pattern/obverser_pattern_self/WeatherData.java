package com.lxm.design.pattern.obverser_pattern_self;

import java.util.ArrayList;

public class WeatherData implements Subject{
	 private ArrayList observers;
	 private float temperature;
	 private float humidity;
	 private float pressure;
	 
	 public WeatherData(){
		 this.observers=new ArrayList();
	 }
	 
	 public void registerObserver(Observer observer) {
		 this.observers.add(observer);
	 }
	 
	 @Override
	 public void removeObserver(Observer obverser) {
		 if(this.observers.contains(obverser)){
			 this.observers.remove(obverser);
		 }
	 }
	 
	 @Override
	 public void notifyObservers() {	
		 for(int i=0;i<this.observers.size();i++){
			 Observer obverser=(Observer) this.observers.get(i);
			 obverser.update(this.temperature,this.humidity, this.pressure);
		 }
	 }
	 
	 public void measurementsChanged(){
		 this.notifyObservers();
	 }
	 
	 public void setMeasurements(float temperature,float humidity,float pressure){
		 this.temperature=temperature;
		 this.humidity=humidity;
		 this.pressure=pressure;
		 this.measurementsChanged();
	 }
	 
	public ArrayList getObservers() {
		return observers;
	}

	public void setObservers(ArrayList observers) {
		this.observers = observers;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
}
