package com.lxm.leetcode;

/**
 * Created by LXM on 2019/6/21.
 */
public class LinkedListTest {

    public Node insert(Node list, Integer data) {
        if (list == null) {
            list = new Node(data, null);
            return list;
        }
        Node l = list;
        while (l.next != null) {
            l = l.next;
        }
        l.next = new Node(data, null);
        return list;
    }

    public void traverse(Node list) {
        Node l = list;
        while (l != null) {
            System.out.print(l.data + " ");
            l = l.next;
        }
    }

    public Node find(Node list, Integer data) {
        Node l = list;
        while (l != null) {
            if (l.data.equals(data)) {
                return l;
            }
            l = l.next;
        }
        return null;
    }

    public Node remove(Node list, Integer data) {
        Node l = list, prev = null;
        while (l != null) {
            if (l.data.equals(data)) {
                if (prev != null) {
                    prev.next = l.next;
                }
                return l;
            }
            prev = l;
            l = l.next;
        }
        return null;
    }

    public Node reverse(Node head) {
        //单链表为空或只有一个节点，直接返回原单链表
        if (head == null || head.next == null) {
            return head;
        }
        //前一个节点指针
        Node pre = null;
        //当前节点指针
        Node cur = head;
        //下一个节点指针
        Node next = null;
        while (cur != null) {
            next = cur.next;//nextNode 指向下一个节点
            cur.next = pre;//将当前节点next域指向前一个节点
            pre = cur;//preNode 指针向后移动
            cur = next;//curNode指针向后移动
        }
        return pre;
    }

    public static void main(String[] args) {
        LinkedListTest test = new LinkedListTest();
        Node list = null;
        list = test.insert(list, 1);
        list = test.insert(list, 2);
        list = test.insert(list, 3);
        list = test.insert(list, 4);
        list = test.insert(list, 5);

//        test.traverse(list);

        Node temp = test.find(list, 3);
//        System.out.print(temp);

//        Node deleteNode = test.remove(list,1);
//        System.out.print(deleteNode);

        Node l = test.reverse(list);
        test.traverse(l);
    }
}
