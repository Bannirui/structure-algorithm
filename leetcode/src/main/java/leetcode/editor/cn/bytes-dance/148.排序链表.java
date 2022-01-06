/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    public ListNode sortList(ListNode head) {
        return this.split(head, null);
    }

    // [head, null)
    private ListNode split(ListNode head, ListNode tail){
        if(head==null) return head;
        if(head.next==tail){
            head.next=null;
            return head;
        }
        ListNode slow=head, fast=head;
        while(fast!=tail){
            slow=slow.next;
            fast=fast.next;
            if(fast!=tail){
                fast=fast.next;
            }
        }
        // slow is the middle node
        ListNode node1 = split(head, slow); // [head...slow)
        ListNode node2 = split(slow, tail); // [slow...tail)
        return this.merge(node1, node2);
    }

    private ListNode merge(ListNode head1, ListNode head2){
        if(head1==null) return head2;
        if(head2==null) return head1;
        if(head1.val<=head2.val){
            head1.next=this.merge(head1.next, head2);
            return head1;
        }else{
            head2.next=this.merge(head1, head2.next);
            return head2;
        }
    }
}
// @lc code=end

