package com.lxm.design.pattern.factory_pattern_java.abstractFactory;

public class BeiJingPizzaStore extends PizzaStore {

	private SourceFactory sourceFactory;

	public BeiJingPizzaStore(SourceFactory sourceFactory){
		this.sourceFactory=sourceFactory;
	}

	public Pizza createPizza(String type) {
		Pizza pizza=null;
		if(type.equals("apple")){
			pizza=new ApplePizza(sourceFactory);
		}
		if(type.equals("cheese")){
			pizza=new CheesePizza(sourceFactory);
		}
		return pizza;
	}

}
