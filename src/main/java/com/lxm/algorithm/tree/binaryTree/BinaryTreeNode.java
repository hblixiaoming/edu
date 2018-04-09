package com.lxm.algorithm.tree.binaryTree;

public class BinaryTreeNode {
	/**
	 * ���ڵ������
	 */
	private String data;
	/**
	 * ������
	 */
	private BinaryTreeNode leftChild;
	/**
	 * ������
	 */
	private BinaryTreeNode rightChild;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public BinaryTreeNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(BinaryTreeNode leftChild) {
		this.leftChild = leftChild;
	}
	public BinaryTreeNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(BinaryTreeNode rightChild) {
		this.rightChild = rightChild;
	}
}
