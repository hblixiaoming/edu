package com.lxm.design.pattern.factory_pattern_java.normalFactory;

public abstract class Pizza {
	protected String name;
	protected float price;
	
	public void prepare(){
		System.out.println("prepare "+this.name);
	}
	
	public void bake(){
		System.out.println("bake "+this.name);
	}
	
	public void cut(){
		System.out.println("cut "+this.name);
	}
	
	public void box(){
		System.out.println("box "+this.name);
	}
	
	public String getName(){
		return this.name;
	}
	
	
}
