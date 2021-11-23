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
        // 链表中间节点
        // 双指针
        ListNode fast=head, slow=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            prev=slow;
            fast=fast.next.next;
            slow=slow.next;
        }
        // 一分为二
        ListNode head1 = head;
        ListNode head2 = slow.next;
        slow.next=null;
        // 后半段翻转
        head2 = this.reverse(head2);
        // 交叉
        head = this.combine(head1,head2);
    }

    // 链表翻转
    private ListNode reverse(ListNode head){
        // base case
        if(head==null || head.next==null){
            return head;
        }
        ListNode newHead = this.reverse(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

    // head1的长度>=head2的长度
    private ListNode combine(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode cur1=head1;
        ListNode cur2=head2;
        while(cur2!=null){
            cur.next=cur1;
            cur1=cur1.next;
            cur=cur.next;

            cur.next=cur2;
            cur2=cur2.next;
            cur=cur.next;
        }
        // head2走完 head1可能还没走完
        cur.next = cur1;
        return dummy.next;
    }
}
// @lc code=end

