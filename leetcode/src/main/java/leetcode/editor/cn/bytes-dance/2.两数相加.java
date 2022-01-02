/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<Integer> q1 = new LinkedList<>(); // l1 node
        Queue<Integer> q2 = new LinkedList<>(); // l2 node
        while(l1!=null){
            q1.offer(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            q2.offer(l2.val);
            l2=l2.next;
        }
        Queue<Integer> q = new LinkedList<>();
        int carry = 0; // record the carry since add
        while(!q1.isEmpty()||!q2.isEmpty()){
            int n1 = q1.isEmpty()?0:q1.poll();
            int n2 = q2.isEmpty()?0:q2.poll();
            int sum = n1+n2+carry;
            q.offer(sum%10);
            carry=sum/10;
        }
        if(carry!=0) q.offer(carry);
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(!q.isEmpty()){
            cur.next = new ListNode(q.poll());
            cur=cur.next;
        }
        return dummy.next;
    }
}
// @lc code=end

