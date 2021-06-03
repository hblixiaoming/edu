package com.lxm.leetcode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question206 {
    public ListNode reverseList(ListNode head) {
//单链表为空或只有一个节点，直接返回原单链表
        if (head == null || head.next == null) {
            return head;
        }
        //前一个节点指针
        ListNode pre = null;
        //当前节点指针
        ListNode cur = head;
        //下一个节点指针
        ListNode next = null;
        while (cur != null) {
            next = cur.next;//nextNode 指向下一个节点
            cur.next = pre;//将当前节点next域指向前一个节点
            pre = cur;//preNode 指针向后移动
            cur = next;//curNode指针向后移动
        }
        return pre;
    }
}
