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
        int lenA=this.getLen(headA);
        int lenB=this.getLen(headB);
        ListNode curA=headA;
        ListNode curB=headB;
        // 先走
        int gap=0;
        if(lenA>lenB){
            gap=lenA-lenB;
            while(gap!=0){
                curA=curA.next;
                gap--;
            }
        }else{
            gap=lenB-lenA;
            while(gap!=0){
                curB=curB.next;
                gap--;
            }
        }
        // 一起走
        while(curA!=curB){
            if(curA.next==null||curB.next==null){
                return null;
            }
            curA=curA.next;
            curB=curB.next;
        }
        return curA;
    }

    private int getLen(ListNode head){
        if(head==null){
            return 0;
        }
        int len=0;
        while(head!=null){
            len++;
            head=head.next;
        }
        return len;
    }
}
// @lc code=end

