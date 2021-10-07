/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // base case
        if (head == null || n < 1) {
            return head;
        }
        // 从头遍历到尾
        ListNode cur = head;
        while (cur != null) {
            n--;
            cur = cur.next;
        }
        // 分别考量此时n的值
        if (n > 0) {
            return head;
        } else if (n == 0) {
            // 移除正数第1个节点
            return head.next;
        } else {
            // 当前idx=k-n 倒数第k个移除 找到倒数第k+1个=(n+1)-(K+1)=n-k 也就是0-idx
            cur = head;
            while (++n != 0) {
                cur = cur.next;
            }
            // 找到了移除的前一个节点
            cur.next = cur.next.next;
            return head;
        }
    }
}
// @lc code=end
