/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    public ListNode sortList(ListNode head) {

        return this.sortList(head, null);
    }

    // [start...end)排序
    private ListNode sortList(ListNode start, ListNode end){
        // base case
        if(start==null){
            return start;
        }
        if(start.next==end){
            start.next=null;
            return start;
        }
        // 找到中间节点 快慢指针
        ListNode slow=start;
        ListNode fast=start;
        while(fast!=end){
            slow=slow.next;
            fast=fast.next;
            if(fast!=end){
                fast=fast.next;
            }
        }
        // slow指向了中间(偏左)
        // [head...mid)
        ListNode mid = slow;
        ListNode left = this.sortList(start, mid);
        // [mid...end)
        ListNode right = this.sortList(mid, end);
        // 合并
        ListNode merge = this.merge(left, right);
        return merge;
    }

    // l跟r都是各自有序的
    private ListNode merge(ListNode l, ListNode r){
        // 节点值升序
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        ListNode curL=l, curR=r;
        while(curL!=null&&curR!=null){
            if(curL.val<=curR.val){
                // l小
                cur.next=curL;
                curL=curL.next;
            }else{
                // r小
                cur.next=curR;
                curR=curR.next;
            }
            cur=cur.next;
        }
        if(curL==null){
            cur.next=curR;
        }
        if(curR==null){
            cur.next=curL;
        }
        return dummy.next;
    }
}
// @lc code=end

