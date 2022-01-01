/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        if(head.next.next==null) return head.val==head.next.val;
        ListNode slow = head.next;
        ListNode fast = head.next.next; // not null
        while(fast!=null){
            if(fast.next==null||fast.next.next==null) break;
            slow=slow.next;
            fast=fast.next.next;
        }
        // slow is the middle
        ListNode head1 = head;
        ListNode head2 = this.reverse(slow.next); // head2 must be shorter than head1
        // compare
        while(head2!=null){
            if(head1.val!=head2.val) return false;
            head1=head1.next;
            head2=head2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode newHead = this.reverse(head.next);
        head.next.next = head;
        head.next=null;
        return newHead;
    }
}
// @lc code=end

