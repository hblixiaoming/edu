package com.lxm.design.pattern.factory_pattern_java.abstractFactory;

public class CheesePizza extends Pizza {

	SourceFactory sourceFactory;


	CheesePizza(SourceFactory sourceFactory){
		this.name="cheese";
		this.price=1.3f;
		this.sourceFactory=sourceFactory;
	}

	@Override
	public void prepare() {
		this.flour=sourceFactory.createFlour();
		this.meat=sourceFactory.createMeat();
	}
}
