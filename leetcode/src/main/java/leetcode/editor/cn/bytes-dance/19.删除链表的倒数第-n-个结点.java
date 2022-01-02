/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n<0) throw new RuntimeException("error");
        if(head==null) return null;
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = head; // help ptr
        ListNode slow = dummy; // to find the node before dest
        for(int i=0; i<n; i++){
            fast = fast.next;
        }
        for(;fast!=null;){
            fast=fast.next;
            slow=slow.next;
        } // slow is the left node before pending del
        slow.next = slow.next.next;
        return dummy.next;
    }
}
// @lc code=end

