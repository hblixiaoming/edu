package com.lxm.algorithm.stack.expression;

import java.util.Stack;

public class Calculate {
	Input input;
	Stack<OperaterUnit> operStack;
	Stack<OperaterUnit> opndStack;
	
	public Calculate(Input input){
		this.opndStack=new Stack<OperaterUnit>();
		this.operStack=new Stack<OperaterUnit>();
		this.input=input;
		
	}
	
	private void init(){
		operStack.push(input.getNext());
	}
	
	public double calculate(){
		this.init();
		OperaterUnit next=input.getNext();
		while(!next.isStartOrEnd()||!operStack.peek().isStartOrEnd()){
			//如果是运算数则进栈
			if(next.isOpnd()){
				opndStack.push(next);
				next=input.getNext();
			}else{
				//如果是操作符则比较优先级
				int priority=Priority.comparePriority(operStack.peek().getOper(), next.getOper());
				switch(priority){
				//如果栈顶优先级低则入栈
				case -1:operStack.push(next);next=input.getNext();break;
				//如果相等则出栈，如下一个
				case 0:operStack.pop();next=input.getNext();break;
				//出栈并将运算结果入栈
				case 1:{
					OperaterUnit topU=operStack.pop();
					OperaterUnit b=opndStack.pop();
					OperaterUnit a=opndStack.pop();
					double result=this.cal(Double.parseDouble(a.getOper()),Double.parseDouble(b.getOper()), topU.getOper());
					opndStack.push(OperaterUnitFactory.createOpnd(result));
				};break;
				}
			}
		}
		//返回最终的运算结果
		return Double.parseDouble(opndStack.peek().getOper());
	}
	
	
	/**
	 * 进行计算的方法
	 * @param op1 操作数1
	 * @param op2 操作数2
	 * @param oper 操作符
	 * @return
	 */
	private double cal(double op1,double op2,String oper){
		double result=0.0;
		switch(oper){
		case "+":result=op1+op2;break;
		case "-":result=op1-op2;break;
		case "*":result=op1*op2;break;
		case "/":result=op1/op2;break;
		}
		return result;
	}
}
