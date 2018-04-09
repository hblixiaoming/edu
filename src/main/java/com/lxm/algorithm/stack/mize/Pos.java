package com.lxm.algorithm.stack.mize;

/**
 * λ������
 * @author LXM
 *
 */
public class Pos {
	private int x;
	private int y;
	
	public Pos(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public String toString(){
		return "("+this.getX()+","+this.getY()+")";
	}
	/**
	 * �ж�����λ���ǲ���ͬһ��λ��
	 * @param pos
	 * @return
	 */
	public boolean samePos(Pos pos){
		if(this.getX()==pos.getX()&&this.getY()==pos.getY()){
			return true;
		}else{
			return false;
		}
	}
}
