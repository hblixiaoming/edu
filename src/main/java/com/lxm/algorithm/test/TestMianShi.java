package com.lxm.algorithm.test;

import java.util.*;

/**
 * Created by LXM on 2019/6/26.
 */
public class TestMianShi {

    public int fibRecursion1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return fibRecursion1(n - 1) + fibRecursion1(n - 2);
    }

    public int fibLoop(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int n1 = 1, n2 = 1;
        for (int i = 3; i <= n; i++) {
            int t = n1;
            n1 = n2;
            n2 = t + n2;
        }
        return n2;
    }


    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + ",");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrderStack(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.data + ",");
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + ",");
        inOrder(root.right);
    }

    public void inOrderStack(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            System.out.print(temp.data + ",");
            temp = temp.right;
        }
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + ",");
    }

    public void postOrderStack(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            result.add(temp.data);
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }
        Collections.reverse(result);
        System.out.println(result);
    }

    public Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = null, cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public void traverse(Node list) {
        Node l = list;
        while (l != null) {
            System.out.print(l.data + " ");
            l = l.next;
        }
    }

    public int partSort(int[] array, int low, int high) {
        int key = array[low];
        int pivot = low;
        while (low < high) {
            while (low < high && array[high] >= key)
                high--;
            while (low < high && array[low] <= key)
                low++;
            int temp = array[high];
            array[high] = array[low];
            array[low] = temp;
        }
        int temp = array[low];
        array[low] = array[pivot];
        array[pivot] = temp;
        return low;
    }

    public void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int index = partSort(array, low, high);
        quickSort(array, low, index - 1);
        quickSort(array, index + 1, high);
    }

    public static void main(String[] args) {
        TestMianShi test = new TestMianShi();
//        int result = test.fibRecursion1(50);
//        System.out.println(result);
//        int result1 = test.fibLoop(30);
//        System.out.println(result1);
//
//        TreeNode root = TreeNode.init();
//        System.out.println("preOrder");
//        test.preOrder(root);
//        System.out.println();
//        System.out.println("inOrder");
//        test.inOrder(root);
//        System.out.println();
//        System.out.println("postOrder");
//        test.postOrder(root);
//
//        System.out.println();
//        System.out.println("preOrder stack");
//        test.preOrderStack(root);
//
//        System.out.println();
//        System.out.println("inOrder stack");
//        test.inOrderStack(root);
//
//        System.out.println();
//        System.out.println("postOrder stack");
//        test.postOrderStack(root);

//        Node head = Node.init();
//        test.traverse(head);
//        Node newHead = test.reverseList(head);
//        System.out.println("after reverse");
//        test.traverse(newHead);

        int[] array = {4, 3, 1, 2, 6, 7, 5};
        test.quickSort(array, 0, array.length - 1);
        System.out.println(array);
    }
}
