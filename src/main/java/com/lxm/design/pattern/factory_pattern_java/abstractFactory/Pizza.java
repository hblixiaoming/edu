package com.lxm.design.pattern.factory_pattern_java.abstractFactory;

public abstract class Pizza {

	protected Flour flour;
	protected Meat meat;
	protected String name;
	protected float price;

	protected abstract void prepare();

	protected void bake(){
		System.out.println("bake "+this.name);
	}

	protected void cut(){
		System.out.println("cut "+this.name);
	}

	protected void box(){
		System.out.println("box "+this.name);
	}

}
