/*
 * @Author: dingRui
 * @Date: 2021-08-09 14:56:47
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-09 15:11:33
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=328 lang=java
 *
 * [328] 奇偶链表
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 奇数节点 偶数节点
        ListNode oddHead = head, evenHead = head.next;
        ListNode odd = oddHead, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return oddHead;
    }
}
// @lc code=end
