package com.lxm.design.pattern.factory_pattern_java.simpleFactory;

public class Test {
	public static void main(String[] args){
		SimpleFactory factory=new SimpleFactory();
		PizzaStore store=new PizzaStore(factory);
		store.orderPizza("apple");
	}
}
