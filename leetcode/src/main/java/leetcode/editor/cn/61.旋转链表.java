/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return head;
        }
        // 链表长度
        int len = this.getLen(head);
        k %= len;
        if(k==0){
            return head;
        }
        // 整个链表翻转
        head = this.reverse(head);
        // 根据k截断链表
        ListNode cur = head;
        k--;
        while(k>0){
            k--;
            cur = cur.next;
        }
        ListNode next = cur.next;
        cur.next=null;
        // [0...cur]
        head = this.reverse(head);
        // [cur+1...]
        next = this.reverse(next);
        // 遍历找到head的最后一个节点
        cur = head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=next;
        return head;
    }

    // 链表长度
    private int getLen(ListNode head){
        int len=0;
        while(head!=null){
            len++;
            head = head.next;
        }
        return len;
    }

    // 翻转链表
    private ListNode reverse(ListNode head){
        // base case
        if(head==null || head.next==null){
            return head;
        }
        ListNode reversed = this.reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }
}
// @lc code=end

