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
        Deque<Integer> q1 = new LinkedList<>();
        Deque<Integer> q2 = new LinkedList<>();
        Deque<Integer> q = new LinkedList<>();
        // 遍历链表
        while(l1!=null){
            q1.offerLast(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            q2.offerLast(l2.val);
            l2=l2.next;
        }
        // 进位
        int carry = 0;
        while(!q1.isEmpty() || !q2.isEmpty()){
            int num1 = q1.isEmpty()? 0:q1.pollFirst();
            int num2 = q2.isEmpty()? 0:q2.pollFirst();
            int sum = num1+num2+carry;
            int remain = sum%10;
            carry = sum/10;
            q.offerLast(remain);
        }
        if(carry != 0){
            q.offerLast(carry);
        }
        // 链表
        ListNode dummy = new ListNode();
        ListNode cur=dummy;
        while(!q.isEmpty()){
            ListNode newNode = new ListNode(q.pollFirst());
            cur.next = newNode;
            cur=cur.next;
        }
        return dummy.next;
    }
}
// @lc code=end

