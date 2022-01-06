/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head; // base case
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        while(pre!=null){
            ListNode cur = pre.next;
            if(cur==null) return dummy.next;
            ListNode next = cur.next;
            if(next==null) return dummy.next;
            if(cur.val==next.val){
                // pending remove, delete from cur, [cur...]
                ListNode diffVal = cur;
                while(diffVal.val==cur.val){
                    diffVal=diffVal.next;
                    if(diffVal==null){
                        break;
                    }
                }
                cur=diffVal;
                pre.next=diffVal;
            }else{
                // keep cur
                pre=cur;
            }
        }
        return dummy.next;
    }
}
// @lc code=end

