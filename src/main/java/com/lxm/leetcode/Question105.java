package com.lxm.leetcode;

import java.util.HashMap;
import java.util.Map;

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
        Map<Integer, Integer> map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int pPos = 0;
        Integer iPos = null;
        for (; pPos < preorder.length; pPos++) {
            if ((iPos = map.get(preorder[pPos])) != null) {
                break;
            }
        }
        if (iPos < inorder.length) {
            TreeNode root = new TreeNode(preorder[pPos]);
            int[] left = new int[iPos];
            System.arraycopy(inorder, 0, left, 0, iPos);
            int[] right = new int[inorder.length - 1 - iPos];
            System.arraycopy(inorder, iPos + 1, right, 0, inorder.length - 1 - iPos);
            root.left = buildTree(preorder, left);
            root.right = buildTree(preorder, right);
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        Question105 question105 = new Question105();
        int[] preorder = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] inorder = new int[]{4, 2, 5, 1, 6, 3, 7};
        TreeNode treeNode = question105.buildTree(preorder, inorder);
        System.out.println(treeNode);
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
