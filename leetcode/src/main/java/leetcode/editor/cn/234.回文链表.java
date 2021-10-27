/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return true;
        }
        // 找到中间节点
        ListNode mid = this.findMidNode(head);
        // 后半截翻转
        ListNode postReverse = this.reverse(mid.next);
        // 两个链表的比较 n1长度>=n2长度
        ListNode n1 = head, n2 = postReverse;
        boolean allSame = true;
        while (n2 != null) {
            if (n1.val != n2.val) {
                allSame = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        // 还原链表
        mid.next = this.reverse(postReverse);
        return allSame;
    }

    // 快慢指针找到链表中间节点
    private ListNode findMidNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow指向的就是中间节点
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
// @lc code=end
