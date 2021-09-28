import java.util.Queue;

/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 链表head->tail逐个节点求和 保存进位 求和结果放到队列
        Queue<Integer> q = new LinkedList<>();
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            sum %= 10;
            q.offer(sum);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 进位判断
        if (carry > 0) {
            q.offer(carry);
        }
        ListNode dummyNode = new ListNode(), head = dummyNode;
        while (!q.isEmpty() && head != null) {
            head.next = new ListNode(q.poll());
            head = head.next;
        }
        return dummyNode.next;
    }
}
// @lc code=end
