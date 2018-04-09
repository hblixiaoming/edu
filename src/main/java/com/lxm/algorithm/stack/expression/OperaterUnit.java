package com.lxm.algorithm.stack.expression;

public class OperaterUnit {
	/*计算单元*/
	private String oper;
	/*计算类型0操作数，1操作符*/
	private int type;
	
	/**
	 * 判断是否是起始或者结尾符号
	 * @return
	 */
	public boolean isStartOrEnd(){
		return this.oper.equals("#")?true:false;
	}
	/**
	 * 获得当前是否是操作符
	 * @return
	 */
	public boolean isOper(){
		return this.getType()==1?true:false;
	}
	
	/**
	 * 判断当前对象是否是操作数
	 * @return
	 */
	public boolean isOpnd(){
		return this.getType()==0?true:false;
	}
	
	
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.oper;
	}
	
	
	
}
