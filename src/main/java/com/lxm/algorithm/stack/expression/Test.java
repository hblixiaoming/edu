package com.lxm.algorithm.stack.expression;

public class Test {
	public static void main(String[] args){
		Input inpit=new InputDirectly();
		Calculate calculate=new Calculate(inpit);
		System.out.println(calculate.calculate());
		
	}
}
