/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        return this.dfs(head);
    }

    private ListNode dfs(ListNode head){
        if(head==null || head.next==null) return head; // base case
        ListNode newHead = head.next;
        head.next = this.dfs(newHead.next);
        newHead.next=head;
        return newHead;
    }

    private ListNode iterator(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode pre=dummy;
        while(pre!=null){
            ListNode cur = pre.next;
            if(cur==null) break;
            ListNode next = cur.next;
            if(next==null) break;
            cur.next = next.next;
            next.next=cur;
            pre.next=next;
            pre=cur;
        }
        return dummy.next;
    }
}
// @lc code=end

