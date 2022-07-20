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
        if(head==null) return null;
        ListNode less=new ListNode();
        ListNode greater=new ListNode();
        ListNode l=less, g=greater;
        while(head!=null){
            if(head.val<x){
                l.next=head;
                l=l.next;
            }else{
                g.next=head;
                g=g.next;
            }
            head=head.next;
        }
        g.next=null;
        l.next=greater.next;
        return less.next;
    }
}
// @lc code=end

