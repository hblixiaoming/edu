package com.lxm.leetcode;

import java.util.*;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question104 {
    /**
     * BFS遍历法
     *
     * @param root
     * @return
     */
    public int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            List<TreeNode> temp = new ArrayList<>(queue.size());
            while (!queue.isEmpty()) {
                temp.add(queue.poll());
            }
            for (TreeNode p : temp) {
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
        }
        return level;
    }

    /**
     * DFS遍历法
     *
     * @param root
     * @return
     */
    public int maxDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepthDFS(root.left);
            int rightHeight = maxDepthDFS(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int _val) {
            val = _val;
        }

        public TreeNode(int _val, TreeNode _left, TreeNode _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
