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
        if(head==null || head.next==null) return head;
        if(k==0) return head;
        ListNode cur=head;
        // cnt
        int cnt=this.cnt(cur);
        k %= cnt;
        if(k==0) return head;
        // reverse
        ListNode reversed = this.reverse(head);
        // split
        ListNode dummy = new ListNode(-1, reversed);
        cur=dummy;
        for(int i=0;i<k;i++){
            cur=cur.next;
        }
        ListNode next = cur.next;
        ListNode first = dummy.next;
        cur.next=null;
        dummy.next=this.reverse(dummy.next);
        first.next=this.reverse(next);
        return dummy.next;
    }

    private int cnt(ListNode head){
        if(head==null) return 0;
        int cnt=0;
        while(head!=null){
            cnt++;
            head=head.next;
        }
        return cnt;
    }

    private ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode newHead=this.reverse(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}
// @lc code=end

