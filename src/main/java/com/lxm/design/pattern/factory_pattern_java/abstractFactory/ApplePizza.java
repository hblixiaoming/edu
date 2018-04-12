package com.lxm.design.pattern.factory_pattern_java.abstractFactory;

public class ApplePizza extends Pizza {

	private SourceFactory sourceFactory;

	public ApplePizza(SourceFactory sourceFactory){
		this.name="apple pizza";
		this.price=2.3f;
		this.sourceFactory=sourceFactory;
	}

	@Override
	public void prepare() {
		this.flour=sourceFactory.createFlour();
		this.meat=sourceFactory.createMeat();
	}
}
