package com.lxm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question226 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public TreeNode invertTreeBFS(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode r = queue.poll();
            TreeNode lc = r.left;
            TreeNode rc = r.right;
            r.left = rc;
            r.right = lc;
            if (lc != null) {
                queue.offer(lc);
            }
            if (rc != null) {
                queue.offer(rc);
            }
        }
        return root;
    }

    public TreeNode invertTreeDFS(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode lc = root.left;
        TreeNode rc = root.right;
        root.left = rc;
        root.right = lc;
        if (lc != null) {
            invertTreeDFS(lc);
        }
        if (rc != null) {
            invertTreeDFS(rc);
        }
        return root;
    }
}
