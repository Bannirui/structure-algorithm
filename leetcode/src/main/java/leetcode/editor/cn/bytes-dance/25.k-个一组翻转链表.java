/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy; // reverse from pre.next
        while(pre!=null){
            // [pre.next...] length is shorter than k then quit
            ListNode tmp = pre;
            for(int i=0;i<k;i++){
                tmp = tmp.next;
                if(tmp==null){
                    return dummy.next;
                }
            }
            ListNode cur = pre.next;
            int times = k;
            while(times-1>0 && cur!=null && cur.next!=null){ // reverse times for a loop
                ListNode next = cur.next;
                cur.next = next.next;
                next.next=pre.next;
                pre.next=next;
                times--;
            }
            pre = cur;
        }
        return dummy.next;
    }
}
// @lc code=end

