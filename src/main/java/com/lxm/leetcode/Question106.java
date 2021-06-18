package com.lxm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question106 {
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int pPos = postorder.length - 1;
        Integer iPos = null;
        for (; pPos >= 0; pPos--) {
            if ((iPos = map.get(postorder[pPos])) != null) {
                break;
            }
        }
        if (iPos < inorder.length) {
            TreeNode root = new TreeNode(postorder[pPos]);
            int[] left = new int[iPos];
            System.arraycopy(inorder, 0, left, 0, iPos);
            int[] right = new int[inorder.length - 1 - iPos];
            System.arraycopy(inorder, iPos + 1, right, 0, inorder.length - 1 - iPos);
            root.left = buildTree(left, postorder);
            root.right = buildTree(right, postorder);
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        Question106 question106 = new Question106();
        int[] inorder = new int[]{4, 2, 5, 1, 6, 3, 7};
        int[] postorder = new int[]{4, 5, 2, 6, 7, 3, 1};
        TreeNode treeNode = question106.buildTree(inorder, postorder);
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
