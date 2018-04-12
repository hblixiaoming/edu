package com.lxm.design.pattern.decorator_pattern_java;

/**
 * 这是另一种饮料
 * @author lenovo
 *
 */
public class HouseBlend extends Beverage{
	
	public HouseBlend(){
		this.description="House Blend Coffee";
	}
	@Override
	public double cost() {
		return 0.89;
	}

}
