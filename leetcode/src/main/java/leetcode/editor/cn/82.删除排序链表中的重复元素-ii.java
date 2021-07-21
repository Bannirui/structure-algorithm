/*
 * @Author: dingrui
 * @Date: 2021-07-21 20:48:45
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-21 21:25:08
 * @Descripttion: 
 */
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
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(-1, head);
        ListNode cur = newHead;
        // cur是唯一的 检测[cur...]
        while (cur.next != null && cur.next.next != null) {
            // 重复值存在一定是连续的
            if (cur.next.val == cur.next.next.val) {
                int repeat = cur.next.val;
                // 找到[cur.next ...]第一个val不是重复值的
                while (cur.next != null && cur.next.val == repeat) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }

        }
        return newHead.next;
    }
}
// @lc code=end
