package com.lxm.algorithm.test;

/**
 * Created by LXM on 2019/6/26.
 */
public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;


    public static TreeNode init() {
        TreeNode root = new TreeNode();
        root.data = 1;

        TreeNode left1 = new TreeNode();
        left1.data = 2;
        root.left = left1;

        TreeNode right1 = new TreeNode();
        right1.data = 3;
        root.right = right1;

        TreeNode left11 = new TreeNode();
        left11.data = 4;
        left1.left = left11;

        TreeNode right11 = new TreeNode();
        right11.data = 5;
        left1.right = right11;

        TreeNode left12 = new TreeNode();
        left12.data = 6;
        right1.left = left12;

        TreeNode right12 = new TreeNode();
        right12.data = 7;
        right1.right = right12;

        return root;
    }
}
