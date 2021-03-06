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
        if(headA==null||headB==null){
            return null;
        }
        // two pointer
        ListNode aPtr = headA;
        ListNode bPtr = headB;
        while(aPtr!=bPtr){
            aPtr = aPtr==null? headB: aPtr.next;
            bPtr = bPtr==null? headA: bPtr.next;
        }
        // aPtr==bPtr
        return aPtr;
    }
}
// @lc code=end

