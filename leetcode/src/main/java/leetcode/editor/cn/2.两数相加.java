import java.util.Deque;

import leetcode.editor.cn.DeleteNodeInALinkedList.ListNode;

/*
 * @Author: dingrui
 * @Date: 2021-07-15 13:37:51
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-15 14:06:03
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 结果头节点
        ListNode head = null;
        ListNode tail = null;
        // 十进制相加进位
        int take = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2 + take;
            take = sum / 10;
            if (head != null) {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            } else {
                head = new ListNode(sum % 10);
                tail = head;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (take != 0) {
            if (head != null) {
                tail.next = new ListNode(take);
                tail = tail.next;
            } else {
                head = new ListNode(take);
                tail = head;
            }
        }
        // cur就是新链表的最后节点
        return head;
    }
}
// @lc code=end
