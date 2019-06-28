package com.lxm.leetcode;

/**
 * Created by LXM on 2019/6/21.
 */
public class Node {
    Node next;
    Integer data;

    public Node() {
    }

    public Node(Integer data, Node next) {
        this.data = data;
        this.next = next;
    }
}
