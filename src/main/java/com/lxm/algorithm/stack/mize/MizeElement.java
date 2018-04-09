package com.lxm.algorithm.stack.mize;

/**
 * �Թ�Ԫ�ض���
 * @author LXM
 *
 */
public class MizeElement {
	/**
	 * ǽ����ͨ·�ı�־ 1����ǽ��0����ͨ·
	 */
	private int canPass=0;
	/**
	 * �Ƿ��Ѿ�̽�����ı�־ 1��0����
	 */
	private int hasPass=0;
	
	
	public MizeElement(int canPass){
		this.canPass=canPass;
	}
	
	public int getCanPass() {
		return canPass;
	}
	public void setCanPass(int canPass) {
		this.canPass = canPass;
	}
	public int getHasPass() {
		return hasPass;
	}
	public void setHasPass(int hasPass) {
		this.hasPass = hasPass;
	}
	
	
}
