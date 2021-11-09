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
        ListNode dummy = new ListNode(-1, head);
        // 先走n个节点
        ListNode fast = dummy;
        while(n!=0){
            fast = fast.next;
            n--;
        }
        // fast slow同时走
        ListNode slow = dummy;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        // slow的下一个节点就是要移除的节点
        slow.next = slow.next.next;
        return dummy.next;
    }
}
// @lc code=end

