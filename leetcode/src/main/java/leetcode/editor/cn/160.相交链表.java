/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 两个链表的长度
        int lenA = this.getLength(headA);
        int lenB = this.getLength(headB);
        ListNode curA=headA;
        ListNode curB=headB;
        if(lenA>lenB){
            // A先后移
            int gap = lenA-lenB;
            while(gap!=0){
                curA=curA.next;
                gap--;
            }
        }else if(lenA<lenB){
            // B先后移
            int gap=lenB-lenA;
            while(gap!=0){
                curB=curB.next;
                gap--;
            }
        }else{
            // 长度相等
        }
        // 同时后移
        while(curA!=curB){
            curA=curA.next;
            curB=curB.next;
        }
        // 重合就是相交节点
        return curA;
    }

    // 求链表的长度
    private int getLength(ListNode head){
        int len=0;
        ListNode cur=head;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        return len;
    }
}
// @lc code=end

