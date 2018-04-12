package com.lxm.design.pattern.factory_pattern_java.simpleFactory;

public class SimpleFactory {
	
	public Pizza createPizza(String type){
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
