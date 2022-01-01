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
        if(head==null || head.next==null || head.next.next==null) return null; // param check
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(slow != fast){ // slow: by one step; fast: by two steps
            if(fast.next==null || fast.next.next==null) return null; // limitted
            slow = slow.next;
            fast = fast.next.next;
        }
        // the two ptr meet: has cycle
        slow = head; // reset
        while(slow != fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
// @lc code=end

