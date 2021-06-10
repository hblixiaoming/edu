package com.lxm.leetcode;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question105 {
    /**
     * int val;
     * *     TreeNode left;
     * *     TreeNode right;
     * *     TreeNode() {}
     * *     TreeNode(int val) { this.val = val; }
     * *     TreeNode(int val, TreeNode left, TreeNode right) {
     * *         this.val = val;
     * *         this.left = left;
     * *         this.right = right;
     * *     }
     * * }
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int i = 0;
        int j = 0;
        for (; i < preorder.length; i++) {
            for (; j < inorder.length; j++) {
                if (preorder[i] == preorder[j]) {
                    break;
                }
            }
        }
        if (j < preorder.length && j < inorder.length) {
            TreeNode root = new TreeNode(preorder[i]);
            int[] left = new int[j];
            System.arraycopy(inorder, 0, left, 0, j);
            int[] right = new int[inorder.length - 1 - j];
            System.arraycopy(inorder, j + 1, right, 0, inorder.length - 1 - j);
            root.left = buildTree(preorder, left);
            root.right = buildTree(preorder, right);
            return root;
        }
        return null;
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
