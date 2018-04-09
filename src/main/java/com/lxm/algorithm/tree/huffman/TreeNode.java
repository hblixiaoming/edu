package com.lxm.algorithm.tree.huffman;

public class TreeNode {
	//����
	private String data;
	//Ȩ��
	private int weight;
	//���ڵ�
	private TreeNode parent;
	//����
	private TreeNode leftChild;
	//�Һ���
	private TreeNode rightChild;
	
	
	public TreeNode(){}
	
	public TreeNode(String data,int weight){
		this.data=data;
		this.weight=weight;
	}
	
	
	/**
	 * �ж��ǲ�������
	 * @return
	 */
	public boolean isLeftChild(){
		return this.parent.getLeftChild()==this?true:false;
	}
	
	/**
	 * �ж��ǲ����Һ���
	 * @return
	 */
	public boolean isRightChild(){
		return this.parent.getRightChild()==this?true:false;
	}
	
	/**
	 * �Ƚ������ڵ��Ȩ��
	 * @param node
	 * @return
	 */
	public int compareWeight(TreeNode node){
		if(this.getWeight()==node.getWeight()){
			return 0;
		}else if(this.getWeight()>node.getWeight()){
			return 1;
		}else if(this.getWeight()<node.getWeight()){
			return -1;
		}
		return 0;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public TreeNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}
	public TreeNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
}
