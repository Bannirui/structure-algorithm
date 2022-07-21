/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return  head;
        ListNode H = head;
        ListNode T = head;
        ListNode cur = head.next;
        while(cur != null){
            ListNode next = cur.next;
            if(cur.val >= T.val)
                T = cur;
            else if(cur.val<=H.val){
                cur.next = H;
                T.next=next;
                H = cur;
            }else{
                // [H...T]第一个>=cur
                ListNode pre=null;
                ListNode tmp = H;
                while(H != T){
                    if(tmp.val>=cur.val) break;
                    pre=tmp;
                    tmp=tmp.next;
                }
                pre.next=cur;
                cur.next=tmp;
                T.next=next;
            }
            cur = next;
        }
        return H;
    }
}
// @lc code=end

