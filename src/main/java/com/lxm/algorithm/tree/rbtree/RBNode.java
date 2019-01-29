package com.lxm.algorithm.tree.rbtree;

public class RBNode<T extends Comparable<T>> {
    char color;
    T key;
    RBNode<T> parent;
    RBNode leftChild;
    RBNode rightChild;

    public RBNode(char col, T key, RBNode parent, RBNode leftChild, RBNode rightChild) {
        this.color = col;
        this.key = key;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}
