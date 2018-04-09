package com.lxm.algorithm.stack.expression;

public class OperaterUnitFactory {
	/**
	 * 生成一个操作数
	 * @param opnd
	 * @return
	 */
	public static OperaterUnit createOpnd(double opnd){
		OperaterUnit op=new OperaterUnit();
		op.setType(0);
		op.setOper(String.valueOf(opnd));
		return op;
	}
	
	/**
	 * 生成一个操作符
	 * @param oper
	 * @return
	 */
	public static OperaterUnit createOper(String oper){
		OperaterUnit op=new OperaterUnit();
		op.setType(1);
		op.setOper(String.valueOf(oper));
		return op;
	}
}
