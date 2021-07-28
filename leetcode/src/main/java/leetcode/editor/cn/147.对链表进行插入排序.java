import leetcode.editor.cn.DeleteNodeInALinkedList.ListNode;

/*
 * @Author: dingrui
 * @Date: 2021-07-27 23:33:31
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-28 11:49:55
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 虚拟头节点
        ListNode dummy = new ListNode(-1, head);
        ListNode lastOrder = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (lastOrder.val <= cur.val) {
                // 有序 指针后移
                lastOrder = lastOrder.next;
            } else {
                // 排序 在[...lastOrder]中找插入点给cur
                ListNode prev = dummy;
                while (prev.next.val <= cur.val) {
                    prev = prev.next;
                }
                // 找到了插入点
                lastOrder.next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
            }
            cur = lastOrder.next;
        }
        return dummy.next;
    }
}
// @lc code=end
