import leetcode.editor.cn.DeleteNodeInALinkedList.ListNode;

/*
 * @Author: dingrui
 * @Date: 2021-07-26 14:51:09
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-28 14:45:49
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 插入排序
        ListNode dummy = new ListNode(-1, head);
        ListNode lastOrder = head, cur = head.next;
        while (cur != null) {
            if (lastOrder.val <= cur.val) {
                // 有序 后移指针
                lastOrder = lastOrder.next;
            } else {
                // 需要排序 在[...lastOrder]中找到待插入的位置给cur
                ListNode prev = dummy;
                while (prev.next.val <= cur.val) {
                    prev = prev.next;
                }
                // prev后继节点的位置就是cur待插入的位置
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
