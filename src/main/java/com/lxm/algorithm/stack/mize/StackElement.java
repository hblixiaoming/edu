package com.lxm.algorithm.stack.mize;

public class StackElement {
	/**
	 * λ������
	 */
	private Pos pos;
	/**
	 * �Ѿ�̽�����ķ���ȡ�� 1����2�ϣ�3����4��
	 */
	private int direction=1;
	
	
	public StackElement(Pos pos){
		this.pos=pos;
		this.direction=1;
	}
	
	public StackElement(Pos pos,int direction){
		this.pos=pos;
		this.direction=direction;
	}
	
	
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public Pos getPos() {
		return pos;
	}
	public void setPos(Pos pos) {
		this.pos = pos;
	}
}
