package com.lxm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question116 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        int level = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int num = 0;
        Node r = root;
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            num++;
            if (r.left == n) {
                level++;
                r = n;
            }
            int lEndNum = (int) Math.pow(2.0, level) - 1;
            if (lEndNum != num) {
                n.next = queue.peek();
            }
            if (n.left != null) {
                queue.offer(n.left);
            }
            if (n.right != null) {
                queue.offer(n.right);
            }
        }
        return root;
    }

    /**
     * 一次同层全部出队列版
     * @param root
     * @return
     */
    public Node connect1(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<Node> levelList = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 当前层都出队列
            while (!queue.isEmpty()) {
                levelList.add(queue.poll());
            }
            for (int i = 0; i < levelList.size(); i++) {
                if (i + 1 < levelList.size()) {
                    levelList.get(i).next = levelList.get(i + 1);
                }
                if (levelList.get(i).left != null) {
                    queue.offer(levelList.get(i).left);
                }
                if (levelList.get(i).right != null) {
                    queue.offer(levelList.get(i).right);
                }
            }
            levelList.clear();
        }
        return root;
    }

    /**
     * 官方版
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }

        // 初始化队列同时将第一层节点加入队列中，即根节点
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        // 外层的 while 循环迭代的是层数
        while (!queue.isEmpty()) {

            // 记录当前队列大小
            int size = queue.size();

            // 遍历这一层的所有节点
            for (int i = 0; i < size; i++) {

                // 从队首取出元素
                Node node = queue.poll();

                // 连接
                if (i < size - 1) {
                    node.next = queue.peek();
                }

                // 拓展下一层节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        // 返回根节点
        return root;
    }

    public static void main(String[] args) {
        Node node4 = new Node(4, null, null, null);
        Node node5 = new Node(5, null, null, null);
        Node node6 = new Node(6, null, null, null);
        Node node7 = new Node(7, null, null, null);
        Node node2 = new Node(2, node4, node5, null);
        Node node3 = new Node(3, node6, node7, null);
        Node node1 = new Node(1, node2, node3, null);
        Question116 question116 = new Question116();
        question116.connect1(node1);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}

