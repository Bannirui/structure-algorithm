/*
 * @Author: dingrui
 * @Date: 2021-07-27 17:29:35
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-27 17:46:06
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // 结论 快慢指针
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        // 先找快慢指针相遇的节点
        ListNode fast = head.next.next, slow = head.next;
        while (fast != slow) {
            // 快指针2步 慢指针1步
            if (slow.next == null || fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        // 此刻slow就停在首次相遇的节点 fast回到head
        fast = head;
        // fast和slow一次一步 再次相遇的时候就是入环节点
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
// @lc code=end
