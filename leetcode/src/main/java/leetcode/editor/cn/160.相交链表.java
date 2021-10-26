import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 暴力法
        // return this.force(headA, headB);

        // 进阶 O(1)空间复杂度
        return this.better(headA, headB);
    }

    // 进阶 O(1)空间复杂度
    private ListNode better(ListNode head1, ListNode head2) {
        // 计算两条链表的长度 从交叉点开始 后面的长度开始一样 两条原始链表从等长度的地方开始出发
        int l1 = getLen(head1);
        int l2 = getLen(head2);
        if (l1 != l2) {
            if (l1 > l2) {
                head1 = this.step(head1, l1 - l2);
            } else {
                head2 = this.step(head2, l2 - l1);
            }
        }
        // head1 head2两条链表等长 找交叉点
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                // 交叉点
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        // 链表遍历完也没找到交叉节点就是不存在交叉节点
        return null;
    }

    // 链表长度
    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    // 链表舍弃前n个节点
    private ListNode step(ListNode head, int cnt) {
        while (cnt != 0) {
            head = head.next;
            cnt--;
        }
        return head;
    }

    // 暴力解法
    private ListNode force(ListNode head1, ListNode head2) {
        // 遍历一条链表放到hash表中
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode cur1 = head1;
        while (cur1 != null) {
            nodeSet.add(cur1);
            cur1 = cur1.next;
        }

        ListNode cur2 = head2;
        while (cur2 != null) {
            if (nodeSet.contains(cur2)) {
                // 2条链表首次出现相同节点就是交叉节点
                return cur2;
            }
            cur2 = cur2.next;
        }
        return null;
    }
}
// @lc code=end
