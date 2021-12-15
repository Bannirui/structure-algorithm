/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        // pre node left over pending reverse
        ListNode pre = dummy;
        for(int i=0; i<left-1; i++){
            pre = pre.next;
        }
        // first node for pending reverse, keeping but the next will changed
        ListNode cur = pre.next;
        // the next node for cur
        ListNode next = null;
        for(int i=0; i<right-left;i++){
            // update next
            next = cur.next;
            cur.next=next.next;
            next.next=pre.next;
            pre.next=next;

        }
        return dummy.next;
    }
}
// @lc code=end

