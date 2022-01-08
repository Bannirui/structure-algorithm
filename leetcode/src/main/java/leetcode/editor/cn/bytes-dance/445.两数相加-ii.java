/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
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
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1!=null){
            s1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            s2.push(l2.val);
            l2=l2.next;
        }
        Stack<Integer> s = new Stack<>();
        int carry = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            int n1=s1.isEmpty()?0:s1.pop();
            int n2=s2.isEmpty()?0:s2.pop();
            int sum = n1+n2+carry;
            s.push(sum%10);
            carry=sum/10;
        }
        if(carry!=0) s.push(carry);
        ListNode dummy = new ListNode();
        ListNode cur=dummy;
        while(!s.isEmpty()){
            cur.next=new ListNode(s.pop());
            cur=cur.next;
        }
        return dummy.next;
    }
}
// @lc code=end

