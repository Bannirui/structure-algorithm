/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
    public boolean isPalindrome(ListNode head) {
        // base case
        if(head==null){
            return true;
        }
        // 找到中间节点
        // 双指针
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        // slow就是中间节点
        // 后半段翻转
        ListNode reversePostHalf = this.reverse(slow.next);
        // 两条链表最多只相差一个节点 遍历完其中一条即可
        ListNode curPre=head;
        ListNode curPost=reversePostHalf;
        while(curPre!=null&&curPost!=null){
            if(curPre.val!=curPost.val){
                // 但凡一个节点的值不一样即可退出
                return false;
            }
            curPre=curPre.next;
            curPost=curPost.next;
        }
        // 退出前还原原来的数据结构
        slow.next=this.reverse(reversePostHalf);
        return true;
    }

    // 单链表翻转
    private ListNode reverse(ListNode head){
        // base case
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead = this.reverse(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}
// @lc code=end

