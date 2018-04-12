package com.lxm.design.pattern.strategy_pattern_self;

public class GreenDuck extends Duck{
	private FlyBehavior fly;
	private QuackBehavior quack;
	
	public GreenDuck(FlyBehavior fly,QuackBehavior quack){
		super();
		this.fly=fly;
		this.quack=quack;
	}
}
