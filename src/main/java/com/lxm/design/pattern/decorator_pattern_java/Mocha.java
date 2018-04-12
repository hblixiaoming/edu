package com.lxm.design.pattern.decorator_pattern_java;
/**
 * 这是一个调料类
 * @author lenovo
 *
 */
public class Mocha extends CondimentDecorator{
	Beverage beverage;
	
	public Mocha(Beverage beverage){
		this.beverage=beverage;
	}
	@Override
	public String getDescription() {
		return beverage.getDescription()+",Mocha";
	}

	@Override
	public double cost() {
		return 0.20+beverage.cost();
	}
	
}
