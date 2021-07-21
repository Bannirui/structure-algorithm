import leetcode.editor.cn.DeleteNodeInALinkedList.ListNode;

/*
 * @Author: dingrui
 * @Date: 2021-07-21 21:59:21
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-21 22:33:02
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
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
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = null, lessTail = null;
        ListNode greaterHead = null, greaterTail = null;
        ListNode next = null;
        // 遍历
        while (head != null) {
            next = head.next;
            head.next = null;
            int curVal = head.val;
            if (curVal < x) {
                if (lessHead == null) {
                    lessHead = head;
                    lessTail = lessHead;
                } else {
                    lessTail.next = head;
                    lessTail = lessTail.next;
                }
            } else {
                if (greaterHead == null) {
                    greaterHead = head;
                    greaterTail = greaterHead;
                } else {
                    greaterTail.next = head;
                    greaterTail = greaterTail.next;
                }
            }
            head = next;
        }
        // 合并
        if (lessTail != null) {
            lessTail.next = greaterHead;
        }
        return lessHead != null ? lessHead : greaterHead;
    }
}
// @lc code=end
