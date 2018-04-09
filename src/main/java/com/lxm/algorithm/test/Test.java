package com.lxm.algorithm.test;

public class Test {
	public static void main(String[] args){
		//Apple apple=new Apple();
		Color color=new Color();
		//apple.setColor(color);
		
		Test tst=new Test();
		tst.changeColor(color);
		System.out.println(color.getDisplay());
		tst.changeColor1(color);
		System.out.println(color.getDisplay());
	}
	
	public void changeColor(Color color){
		color.setDisplay("��ɫ");
	}
	
	public void changeColor1(Color color){
		color=new Color();
		color.setDisplay("��ɫ");
	}
}


