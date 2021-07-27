/*
 * @Author: dingrui
 * @Date: 2021-07-27 17:47:16
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-27 21:32:15
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        // 遍历链表
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int start = 0, end = list.size() - 1;
        while (start < end) {
            list.get(start).next = list.get(end);
            start++;
            if (start == end) {
                break;
            }
            list.get(end).next = list.get(start);
            end--;
        }
        // 此刻start==end
        list.get(start).next = null;
    }
}
// @lc code=end
