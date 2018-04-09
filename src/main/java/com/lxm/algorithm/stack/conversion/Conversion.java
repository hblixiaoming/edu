package com.lxm.algorithm.stack.conversion;

import java.util.Stack;


/**
 * ʵ��ʮ����ת��Ϊ�������Ƶķ���
 * �㷨��
 * ���豻ת����ʮ��������ΪA��ת���Ľ���ΪN
 * while(A){ 
 * 	A%N->stack;
 * 	A=A/N;
 * }
 * stack->result
 * @author lenovo
 *
 */
public class Conversion {
	/**
	 * Ŀ�����
	 */
	public static final int N=2;
	
	/**
	 * ת������
	 * @param n ��ת������
	 * @return
	 */
	public int[] conversion(int n){
		Stack<Integer> stack=new Stack<Integer>();
		int temp=n;
		while(temp!=0){
			stack.push(temp%N);
			temp=temp/N;
		}
		int[] result=new int[stack.size()];
		int i=0;
		while(!stack.empty()){
			result[i]=stack.pop();
			i++;
		}
		return result;
	}
	
	public void traverse(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+",");
		}
	}
	public static void main(String[] args){
		Conversion con=new Conversion();
		con.traverse(con.conversion(1348));
	}
}
