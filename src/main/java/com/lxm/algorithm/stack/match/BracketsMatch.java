package com.lxm.algorithm.stack.match;

import java.util.Stack;

/**
 * ���ż�ⷽ��
 * @author LXM
 *
 */
public class BracketsMatch {
	
	/**
	 * �������һ�������Ƿ�ƥ��
	 * �㷨
	 * ���������Ŷ���ջ����������������ջ��Ԫ������ƥ������������ջ�Դ�����
	 * @param bracketsListһ������
	 * @return ƥ��true,��ƥ��false
	 */
	public boolean match(Brackets[] bracketsList){
		Stack<Brackets> stack=new Stack<Brackets>();
		//��һ��������ջ
		stack.push(bracketsList[0]);
		for(int i=1;i<bracketsList.length;i++){
			//������������������ջ
			if(bracketsList[i].getTowards()==0){
				stack.push(bracketsList[i]);
			}else{
				Brackets temp=stack.peek();
				//�����ͬһ���͵ģ�������ƥ��ɹ���ջ��Ԫ�س�ջ
				if(temp.getType()==bracketsList[i].getType()){
					stack.pop();
				//��Ȼ��ƥ��ʧ��ֱ�ӷ��ش���
				}else{
					return false;
				}
			}
		}
		if(stack.empty()){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args){
		Brackets[] bracketsList=new Brackets[]{new Brackets("[",0,1),
				new Brackets("(",0,0),
				new Brackets("[",0,1),
				new Brackets("]",1,1),
				new Brackets("[",0,1),
				new Brackets("]",1,1),
				new Brackets(")",1,0),
				new Brackets("]",1,1),};
		BracketsMatch match=new BracketsMatch();
		System.out.println(match.match(bracketsList));
	}
}
