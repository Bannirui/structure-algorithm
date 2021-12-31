/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return;
        // mid
        ListNode slow=head.next, fast=head.next.next;
        while(fast!=null){
            if(fast.next==null) break;
            slow=slow.next;
            fast=fast.next.next;
        }
        // [...slow] [slow.next...]
        ListNode reversed = this.reverse(slow.next);
        slow.next=null;
        this.merge(head, reversed);
    }

    private ListNode reverse(ListNode head){
        // base case
        if(head==null || head.next==null) return head;
        ListNode newHead = this.reverse(head.next);
        head.next.next = head;
        head.next=null;
        return newHead;
    }

    private void merge(ListNode head1, ListNode head2){
        ListNode h1 = head1;
        ListNode h2 = head2;
        while(h2!=null){
            ListNode n1 = h1.next;
            ListNode n2 = h2.next;
            h1.next=h2;
            h2.next=n1;
            h1=n1;
            h2=n2;
        }
    }
}
// @lc code=end

