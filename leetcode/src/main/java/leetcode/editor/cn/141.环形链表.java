/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 暴力法采用hash表存储所有的节点 然后遍历每个节点的next指针 引用存在于hash表中则说明存在环
        // 双指针法 快慢指针
        // base case
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        ListNode slow = head.next, fast = head.next.next;
        while (slow != fast) {
            if (slow == null || fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow跟fast重合 fast回到头节点
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        // 再次重合
        return true;
    }
}
// @lc code=end
