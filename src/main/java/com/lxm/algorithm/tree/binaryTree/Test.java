package com.lxm.algorithm.tree.binaryTree;

public class Test {
	public static void main(String[] args){
		BinaryTree tree=new BinaryTree();
		BinaryTreeNode root=new BinaryTreeNode();
		tree.createBinaryTree(root);
		tree.preOrderTraverse(root);
		System.out.println();
		tree.inOrderTraverse(root);
		System.out.println();
		tree.postOrderTraverse(root);
		System.out.println();
		tree.levelOrderTraverse(root);
	}
}
