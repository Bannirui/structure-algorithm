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
        // 倒数第n个节点
        ListNode dummy = new ListNode(0, head);
        // 让fast从dummy先跑n个节点 然后slow跟着一起步进直到fast到null slow指向待删除节点
        ListNode fast = dummy;
        while(n!=0 && fast!=null){
            fast = fast.next;
            n--;
        }
        // slow跟着fast一起后移 维护prev指向slow的前驱
        ListNode prev = null;
        ListNode slow = dummy;
        while(fast != null){
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        // 此刻slow节点需要删除
        prev.next = slow.next;
        return dummy.next;
    }
}
// @lc code=end

