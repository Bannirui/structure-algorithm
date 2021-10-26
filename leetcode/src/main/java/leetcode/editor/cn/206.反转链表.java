/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // 迭代版本
        // return this.reverse01(head);

        // 递归版本
        return this.reverse02(head);
    }

    // 链表翻转操作到node节点
    private ListNode reverse02(ListNode node) {
        // base case
        if (node == null || node.next == null) {
            return node;
        }
        // (node...]
        ListNode newNextNode = this.reverse02(node.next);
        node.next.next = node;
        node.next = null;
        return newNextNode;
    }

    // 迭代
    private ListNode reverse01(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 前一个节点
        ListNode pre = null;
        ListNode cur = head;
        // 遍历链表节点
        while (cur != null) {
            // 后继节点
            ListNode next = cur.next;
            // 前后翻转
            cur.next = pre;
            // 更新指针
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
// @lc code=end
