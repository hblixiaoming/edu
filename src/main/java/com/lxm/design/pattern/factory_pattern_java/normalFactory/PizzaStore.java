package com.lxm.design.pattern.factory_pattern_java.normalFactory;

public abstract class PizzaStore {
	/**
	 * 抽象的方法，由子类来实现创建pizza的方法
	 * @return
	 */
	public abstract Pizza createPizza(String type);
	
	public Pizza orderPizza(String type){
		//创建一个pizza
		Pizza pizza=this.createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
