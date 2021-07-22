/*
 * @Author: dingrui
 * @Date: 2021-07-22 14:41:16
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-22 15:10:13
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }
        // 一次遍历
        // 虚拟头节点
        ListNode newHead = new ListNode(-1, head);
        // 根据left找到需要开始翻转的前一个位置pre
        ListNode pre = newHead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // cur从pre的下一个节点[...翻转区域最后]
        ListNode cur = pre.next;
        for (int times = 0; times < right - left; times++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return newHead.next;
    }
}
// @lc code=end
