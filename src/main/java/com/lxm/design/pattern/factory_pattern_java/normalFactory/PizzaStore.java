package com.lxm.design.pattern.factory_pattern_java.normalFactory;

public abstract class PizzaStore {
	/**
	 * ����ķ�������������ʵ�ִ���pizza�ķ���
	 * @return
	 */
	public abstract Pizza createPizza(String type);
	
	public Pizza orderPizza(String type){
		//����һ��pizza
		Pizza pizza=this.createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
