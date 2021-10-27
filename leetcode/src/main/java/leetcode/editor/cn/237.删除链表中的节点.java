/*
 * @lc app=leetcode.cn id=237 lang=java
 *
 * [237] 删除链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // 不是末尾
        // 删除node节点的下一个节点
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
// @lc code=end
