package com.lxm.design.pattern.decorator_pattern_java;

/**
 * ����һ��������
 * @author lenovo
 *
 */
public class Espresso extends Beverage{
	public Espresso(){
		this.description="Espresso";
	}
	@Override
	public double cost() {
		return 1.99;
	}

}
