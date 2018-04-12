package com.lxm.design.pattern.decorator_pattern_java;

public abstract class Beverage {
	protected String description="Unknown Beverage";
	public String getDescription(){
		return this.description;
	}
	public abstract double cost();
}
