package com.lxm.algorithm.stack.match;

/**
 * ����һ������
 * @author LXM
 *
 */
public class Brackets {
	/**
	 * ��������
	 */
	private String display;
	/**
	 * ���ŷ��� 
	 * ������0��������1
	 */
	private int towards;
	/**
	 * ���������Ƿ���ͬһ�����ŵ�
	 * С����0��������1��������2
	 */
	private int type;
	
	public Brackets(String display,int towards,int type){
		this.display=display;
		this.towards=towards;
		this.type=type;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public int getTowards() {
		return towards;
	}

	public void setTowards(int towards) {
		this.towards = towards;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
}
