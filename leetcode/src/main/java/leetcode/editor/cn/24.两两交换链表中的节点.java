import leetcode.editor.cn.DeleteNodeInALinkedList.ListNode;

/*
 * @Author: dingrui
 * @Date: 2021-07-15 22:29:19
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-15 22:55:03
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        // 递归
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        // 新链表头节点
        ListNode fir = head.next;
        // 新链表第二节点
        head.next = swapPairs(fir.next);
        fir.next = head;
        return fir;
    }
}
// @lc code=end
