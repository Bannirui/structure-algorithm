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
        if(head==null||head.next==null||head.next.next==null){
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            if(fast.next.next==null){
                return null;
            }
            fast=fast.next.next;
            if(slow==fast){
                // 有环
                fast=head;
                while(fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
// @lc code=end

