package com.lxm.design.pattern.factory_pattern_java.simpleFactory;

public class PizzaStore {
	private SimpleFactory simpleFactory;
	
	PizzaStore(SimpleFactory simpleFactory){
		this.simpleFactory=simpleFactory;
	}
	
	public Pizza orderPizza(String type){
		Pizza pizza=simpleFactory.createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}

	public SimpleFactory getSimpleFactory() {
		return simpleFactory;
	}

	public void setSimpleFactory(SimpleFactory simpleFactory) {
		this.simpleFactory = simpleFactory;
	}
}
