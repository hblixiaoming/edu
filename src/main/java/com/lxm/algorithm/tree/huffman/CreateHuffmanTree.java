package com.lxm.algorithm.tree.huffman;

import java.util.LinkedList;
import java.util.List;

/**
 * ����huffman�����㷨
 * @author LXM
 *
 */
public class CreateHuffmanTree {
	private List<TreeNode> nodeList;
	
	public CreateHuffmanTree(){
		this.init();
	}
	
	/**
	 * ��ʼ������
	 */
	private void init(){
		nodeList=new LinkedList<TreeNode>();
		nodeList.add(new TreeNode("a",7));
		nodeList.add(new TreeNode("b",5));
		nodeList.add(new TreeNode("c",2));
		nodeList.add(new TreeNode("d",4));
	}
	
	/**
	 * �Ƴ�һ���ڵ�
	 */
	public void removeNode(TreeNode node) {
		nodeList.remove(node);
	}
	
	/**
	 * ���һ���ڵ�
	 */
	public void addNode(TreeNode node) {
		nodeList.add(node);
	}
	
	/**
	 * �õ�Ȩ����С�Ľڵ�
	 */
	public TreeNode getMinWeightNode() {
		//�õ���һ���ڵ�
		TreeNode minNode=nodeList.get(0);
		for(TreeNode node:nodeList){
			if(node.getWeight()<minNode.getWeight()){
				minNode=node;
			}
		}
		return minNode;
	}
	
	/**
	 * �õ�����
	 */
	public int getLength() {
		return nodeList.size();
	}
	
	/**
	 * �õ�ָ����Ԫ��
	 */
	public TreeNode get(int index) {
		return nodeList.get(index);
	}
	
	/**
	 * ����huffman�����㷨
	 * ������n��Ȩֵ��������Ĺ���������n��Ҷ�ӽ�㡣 n��Ȩֵ�ֱ���Ϊ w1��w2������wn������������Ĺ������Ϊ��
	 *	(1) ��w1��w2������wn��������n ������ɭ��(ÿ��������һ�����)��
	 *	(2) ��ɭ����ѡ������������Ȩֵ��С�����ϲ�����Ϊһ�������������������������ĸ����ȨֵΪ���������������Ȩֵ֮�ͣ�
	 *	(3)��ɭ����ɾ��ѡȡ����������������������ɭ�֣�
	 *	(4)�ظ�(2)��(3)����ֱ��ɭ����ֻʣһ����Ϊֹ��������Ϊ����õĹ�������
	 * @return
	 */
	public TreeNode createHuffmanTree(){
		//���ֻ��һ���ڵ�����ֱ�ӷ�������ڵ�
		if(this.getLength()==1){
			return this.get(0);
		}
		while(this.getLength()>1){
			//ȡ����Ȩ����С��
			TreeNode node1=this.getMinWeightNode();
			//�Ƴ��������ڵ�
			this.removeNode(node1);
			TreeNode node2=this.getMinWeightNode();
			//�Ƴ��������ڵ�
			this.removeNode(node2);
			TreeNode root=null;
			//���1��Ȩ��С��
			if(node1.compareWeight(node2)==-1){
				//����һ���µ���
				root=this.createTree(node1, node2);
			}else{
				//����һ���µ���
				root=this.createTree(node2, node1);
			}
			//�������ɵĽڵ���ӽ�ȥ
			this.addNode(root);
		}
		//�õ����һ���ڵ�
		return this.get(0);
	}
	
	/**
	 * �������Һ��ӽڵ����ɸ�����һ����
	 * @param leftChild 
	 * @param rightChild
	 * @return
	 */
	private TreeNode createTree(TreeNode leftChild,TreeNode rightChild){
		//���ɸ��ڵ��Ȩ��
		int weight=leftChild.getWeight()+rightChild.getWeight();
		//����һ�����ڵ�
		TreeNode root=new TreeNode();
		//����Ȩ��
		root.setWeight(weight);
		//��������
		root.setLeftChild(leftChild);
		//�����Һ���
		root.setRightChild(rightChild);
		//���ø��ڵ�
		leftChild.setParent(root);
		rightChild.setParent(root);
		return root;
	}
}
