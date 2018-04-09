package com.lxm.algorithm.search;

/**
 * �������ڵ�
 * Created by LXM on 2017/2/1.
 */
public class BinaryTreeNode {
    //����Ȩ��
    int data;
    BinaryTreeNode parent;
    //ָ�����ӵ�ָ��
    BinaryTreeNode lChild;
    //ָ���Һ��ӵ�ָ��
    BinaryTreeNode rChild;

    public BinaryTreeNode(int data){
        this.data=data;
    }

    public BinaryTreeNode(){}

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getlChild() {
        return lChild;
    }

    public void setlChild(BinaryTreeNode lChild) {
        this.lChild = lChild;
    }

    public BinaryTreeNode getrChild() {
        return rChild;
    }

    public void setrChild(BinaryTreeNode rChild) {
        this.rChild = rChild;
    }

    public BinaryTreeNode getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNode parent) {
        this.parent = parent;
    }
}
