package com.lxm.algorithm.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
	/*
	 * ���ɶ�����
	 */
	public void createBinaryTree(BinaryTreeNode root){
		Scanner scan=new Scanner(System.in);
		String str=scan.next();
		if(str.equals("#")){
			root=null;
		}else{
			root.setData(str);
			//����������
			root.setLeftChild(new BinaryTreeNode());
			createBinaryTree(root.getLeftChild());
			//����������
			root.setRightChild(new BinaryTreeNode());
			createBinaryTree(root.getRightChild());
		}
	}
	
	/**
	 * ǰ������
	 */
	public void preOrderTraverse(BinaryTreeNode root){
		if(root!=null&&root.getData()!=null){
			System.out.print(root.getData()+" ");
			preOrderTraverse(root.getLeftChild());
			preOrderTraverse(root.getRightChild());
		}
	}
	/**
	 * �и�����
	 */
	public void inOrderTraverse(BinaryTreeNode root){
		if(root!=null&&root.getData()!=null){
			preOrderTraverse(root.getLeftChild());
			System.out.print(root.getData()+" ");
			preOrderTraverse(root.getRightChild());
		}
	}
	/**
	 * �������
	 */
	public void postOrderTraverse(BinaryTreeNode root){
		if(root!=null&&root.getData()!=null){
			preOrderTraverse(root.getLeftChild());
			preOrderTraverse(root.getRightChild());
			System.out.print(root.getData()+" ");
		}
	}
	
	/**
	 * �ø��ڵ�����У�
	 * ���ڵ���������ӽڵ�����У������в�Ϊ��ʱ����ѭ��
	 * �������
	 */
	public void levelOrderTraverse(BinaryTreeNode root){
		//����һ��queue
		Queue<BinaryTreeNode> queue=new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			BinaryTreeNode temp=queue.poll();
			System.out.print(temp.getData()+" ");
			//���������ڵ������ڵ������
			if(temp.getLeftChild()!=null&&temp.getLeftChild().getData()!=null){
				queue.offer(temp.getLeftChild());
			}
			//��������ҽڵ������ڵ������
			if(temp.getRightChild()!=null&&temp.getRightChild().getData()!=null){
				queue.offer(temp.getRightChild());
			}
		}
	}
	
}
