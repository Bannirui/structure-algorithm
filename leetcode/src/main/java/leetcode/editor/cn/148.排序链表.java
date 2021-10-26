/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        return this.sort(head, null);
    }

    // 1条链表[start...end)区间排序
    private ListNode sort(ListNode start, ListNode end) {
        // base case
        if (start == null) {
            return null;
        }
        // 只有一个节点
        if (start.next == null) {
            return start;
        }
        // 只有两个节点
        if (start.next == end) {
            // 断开start节点上next的引用指向的end
            start.next = null;
            return start;
        }
        // [start...end]区间的中间节点
        ListNode slow = start, fast = start;
        // 快慢指针找mid
        while (fast != end) {
            slow = slow.next;
            fast = fast.next;
            if (fast == end) {
                // 快指针已经走到末尾 慢指针指向的就是中间节点
                break;
            } else {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        // 两边各自排序
        // [start...mid)
        ListNode left = this.sort(start, mid);
        // [mid...end)
        ListNode right = this.sort(mid, end);
        // 合并
        return this.merge(left, right);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while (head1 != null && head2 != null) {
            int val1 = head1.val;
            int val2 = head2.val;
            if (val1 <= val2) {
                head.next = new ListNode(val1);
                head1 = head1.next;
            } else {
                head.next = new ListNode(val2);
                head2 = head2.next;
            }
            head = head.next;
        }
        // 如果其中有一条链表已经全部挂到了结果链表中 剩余一条剩下全部节点直接挂
        if (head1 == null) {
            head.next = head2;
        }
        if (head2 == null) {
            head.next = head1;
        }
        return dummy.next;
    }
}
// @lc code=end
