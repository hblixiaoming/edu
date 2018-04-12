package com.lxm.design.pattern.factory_pattern_java.normalFactory;

public class Test {
	public static void main(String[] args){
		PizzaStore store=new BeiJingPizzaStore();
		Pizza pizza=store.orderPizza("apple");
	}
}
