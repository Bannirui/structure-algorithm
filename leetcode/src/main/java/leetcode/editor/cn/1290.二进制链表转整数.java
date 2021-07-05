import leetcode.editor.cn.DeleteNodeInALinkedList.ListNode;

/*
 * @Author: dingrui
 * @Date: 2021-07-05 13:10:29
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-05 13:12:19
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1290 lang=java
 *
 * [1290] 二进制链表转整数
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
    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode cur = head;
        int res = 0;
        while (cur != null) {
            res = (res << 1) + cur.val;
            cur = cur.next;
        }
        return res;
    }
}
// @lc code=end
