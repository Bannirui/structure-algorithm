/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1!=null || l2!=null){
            if(l1==null){
                head.next=l2;
                break;
            }
            if(l2==null){
                head.next=l1;
                break;
            }
            if(l1.val<=l2.val){
                head.next=l1;
                l1=l1.next;
            }else{
                head.next=l2;
                l2 = l2.next;
            }
            head=head.next;
        }
        return dummy.next;
    }
}
// @lc code=end

