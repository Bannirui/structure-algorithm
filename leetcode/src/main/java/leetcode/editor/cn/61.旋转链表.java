import leetcode.editor.cn.DeleteNodeInALinkedList.ListNode;

/*
 * @Author: dingrui
 * @Date: 2021-07-21 14:14:50
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-21 14:59:04
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // 真实右移长度
        if (k == 0 || head == null) {
            return head;
        }
        int length = this.obtainLength(head);
        if (k % length == 0) {
            return head;
        }
        return this.rotate(head, length - (k % length));
    }

    private ListNode rotate(ListNode head, int k) {
        // 找到新的头节点
        ListNode oldHead = head;
        ListNode newHeadPre = null;
        ListNode newHead = head;
        while (k != 0) {
            newHeadPre = newHead;
            newHead = newHead.next;
            k--;
        }
        // 找到尾节点
        ListNode tail = newHead;
        while (tail.next != null) {
            tail = tail.next;
        }
        // 老头节点挂在尾节点上
        newHeadPre.next = null;
        tail.next = oldHead;
        return newHead;
    }

    private int obtainLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
// @lc code=end
