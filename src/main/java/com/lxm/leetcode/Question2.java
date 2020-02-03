package com.lxm.leetcode;

/**
 * Created by LXM on 2019/12/15.
 */
public class Question2 {

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int n1 = 0, n2 = 0;
//        int c = 0;
//        ListNode p = l1;
//        while (p != null) {
//            n1 = n1 + p.val * qiufang(10, c);
//            c++;
//            p = p.next;
//        }
//        p = l2;
//        c = 0;
//        while (p != null) {
//            n2 = n2 + p.val * qiufang(10, c);
//            c++;
//            p = p.next;
//        }
//        int temp = n1 + n2;
//        ListNode root = null;
//        ListNode pre = null;
//        if (temp == 0) {
//            root = new ListNode(temp);
//        } else {
//            while (temp > 0) {
//                int mode = temp % 10;
//                ListNode t = new ListNode(mode);
//                if (root == null) {
//                    root = t;
//                }
//                if (pre != null) {
//                    pre.next = t;
//                }
//                pre = t;
//                temp = temp / 10;
//            }
//        }
//        return root;
//    }
//
//
//    public int qiufang(int c, int e) {
//        if (e == 0) {
//            return 1;
//        }
//        int r = 1;
//        for (int i = 0; i < e; i++) {
//            r *= c;
//        }
//        return r;
//    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        //        String str1 = "abcde";
//        String str2 = "abc" + new String("de");
//        System.out.println(str1 == str2); false
//        System.out.println(str1.equals(str2)); true

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        Question2 question2 = new Question2();
        question2.addTwoNumbers(n1, l1);

//        ListNode n1 = new ListNode(0);
//        ListNode l1 = new ListNode(0);
//        Question2 question2 = new Question2();
//        question2.addTwoNumbers(n1, l1);
    }
}
