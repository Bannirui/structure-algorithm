import leetcode.editor.cn.DeleteNodeInALinkedList.ListNode;

/*
 * @Author: dingrui
 * @Date: 2021-07-14 18:21:53
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-14 18:45:06
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return this.solution1(head, n);
    }

    // 暴力
    private ListNode solution1(ListNode head, int n) {
        // 节点计数
        int count = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            count++;
        }
        // 倒数n就是正数(count+1-n)
        ListNode pre = head;
        ListNode cur = head.next;
        int index = count + 1 - n;
        if (index == 1) {
            return head.next;
        }
        int curIndex = 2;
        while (curIndex != index) {
            pre = pre.next;
            cur = cur.next;
            curIndex++;
        }
        // curIndex移除
        pre.next = cur.next;
        return head;

    }
}
// @lc code=end
