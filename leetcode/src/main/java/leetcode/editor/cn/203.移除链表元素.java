/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy.next;
        ListNode pre = dummy;
        while(cur != null){
            while(cur!=null&&cur.val==val){
                ListNode next = cur.next;
                pre.next=cur.next;
                cur=next;
            }
            pre=cur;
            if(cur!=null){
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}
// @lc code=end

