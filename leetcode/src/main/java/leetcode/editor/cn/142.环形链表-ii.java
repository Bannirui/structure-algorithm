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
        // base case
        if(head==null || head.next==null || head.next.next==null){
            return null;
        }
        // 快慢指针
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        // 首次相遇
        while(slow!=fast){
            if(fast==null||fast.next==null){
                // fast比slow走的快 链表有尽头说明没有入环节点
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        // 快慢指针相遇 证明链表必有环 重置快指针
        fast = head;
        while(slow!=fast){
            slow = slow.next;
            fast=fast.next;
        }
        // 快慢指针再次相遇 入环节点
        return slow;
    }
}
// @lc code=end

