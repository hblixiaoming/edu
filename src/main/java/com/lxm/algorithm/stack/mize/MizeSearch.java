package com.lxm.algorithm.stack.mize;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * �Թ�����㷨ʵ��
 * @author LXM
 *
 */
public class MizeSearch {
	
	/**
	 * 
	 * @param mize �Թ�
	 * @param start λ�ÿ�ʼ
	 * @param end λ�ý���
	 * @return
	 */
	public List<Pos> mizeSearch(Mize mize,Pos start,Pos end){
		Stack<StackElement> stack=new Stack<StackElement>();
		//��ʼλ��Ԫ����ջ
		stack.push(new StackElement(start));
		//������ʼ���Ѿ������ʹ���
		mize.setHasPass(start);
		//��ջ���յ�����½���ѭ��,����û�е����յ������½�������
		while(!stack.empty()&&!stack.peek().getPos().samePos(end)){
			StackElement nextPos=this.searchNext(mize,stack.peek());
			//����ҵ���·������ջ�����ջ
			if(nextPos!=null){
				stack.push(nextPos);
			}else{
				stack.pop();
			}
		}
		return this.traverse(stack);
	}
	
	/**
	 * ���ĸ�������������ҵ�·��
	 * @param mize
	 * @param stackElement
	 * @return
	 */
	private StackElement searchNext(Mize mize,StackElement stackElement){
		int x=stackElement.getPos().getX();
		int y=stackElement.getPos().getY();
		//������
		Pos eastPos=new Pos(x+1,y);
		if(mize.canPass(eastPos)&&!mize.hasPass(eastPos)){
			mize.setHasPass(eastPos);
			return new StackElement(eastPos,1);
		}
		//��������
		Pos southPos=new Pos(x,y+1);
		if(mize.canPass(southPos)&&!mize.hasPass(southPos)){
			mize.setHasPass(southPos);
			return new StackElement(southPos,2);
		}
		//��������
		Pos westPos=new Pos(x-1,y);
		if(mize.canPass(westPos)&&!mize.hasPass(westPos)){
			mize.setHasPass(westPos);
			return new StackElement(westPos,3);
		}
		//������
		Pos northPos=new Pos(x,y-1);
		if(mize.canPass(northPos)&&!mize.hasPass(northPos)){
			mize.setHasPass(northPos);
			return new StackElement(northPos,4);
		}
		return null;
	}
	
	private List<Pos> traverse(Stack<StackElement> stack){
		List<Pos> posList=null;
		if(!stack.empty()){
			posList=new ArrayList<Pos>();
			for(int i=0;i<stack.size();i++){
				posList.add(stack.pop().getPos());
			}
		}
		return posList;
	}
	
	public static void main(String[] args){
		Mize mize=new Mize();
		mize.init();
		MizeSearch search=new MizeSearch();
		List<Pos> posList=search.mizeSearch(mize, new Pos(1,1), new Pos(8,8));
		for(Pos pos:posList){
			System.out.print(pos.toString()+" ");
		}
	}
}
