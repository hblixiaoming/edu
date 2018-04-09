package com.lxm.algorithm.tree.huffman;

public class Test {
	public static void main(String[] args){
		CreateHuffmanTree createTree=new CreateHuffmanTree();
		TreeNode root=createTree.createHuffmanTree();
		System.out.println(root);
	}
}
