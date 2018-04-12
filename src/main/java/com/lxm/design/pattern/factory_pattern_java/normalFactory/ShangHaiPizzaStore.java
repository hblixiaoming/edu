package com.lxm.design.pattern.factory_pattern_java.normalFactory;

public class ShangHaiPizzaStore extends PizzaStore{

	@Override
	public Pizza createPizza(String type) {
		Pizza pizza=null;
		if(type.equals("apple")){
			pizza=new ApplePizza();
		}
		if(type.equals("cheese")){
			pizza=new CheesePizza();
		}
		return pizza;
	}

}
