/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
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
    public ListNode mergeKLists(ListNode[] lists) {
        // base case
        int len=0;
        if(lists==null || (len=lists.length)==0) return null;
        return this.split(lists, 0, lists.length-1);
    }

    private ListNode split(ListNode[] lists, int l, int r){
        // base case
        if(l==r) return lists[l];
        int mid = l+((r-l)>>1);
        ListNode l1 = this.split(lists, l, mid);
        ListNode l2 = this.split(lists, mid+1, r);
        return this.merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<=l2.val){
            l1.next = this.merge(l1.next, l2);
            return l1;
        }else{
            l2.next=this.merge(l2.next, l1);
            return l2;
        }
    }
}
// @lc code=end

