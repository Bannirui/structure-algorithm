/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur=dummy;
        // 遍历整个链表
        while(cur.next!=null&&cur.next.next!=null){
            if(cur.next.val==cur.next.next.val){
                // 重复 跳过cur之后所有重复节点
                int repeatVal = cur.next.val;
                while(cur.next!=null && cur.next.val==repeatVal){
                    cur.next=cur.next.next;
                }
            }else{
                // 不重复
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}
// @lc code=end

