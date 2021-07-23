import java.util.Stack;

/*
 * @Author: dingrui
 * @Date: 2021-07-22 22:32:02
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-23 16:24:07
 * @Descripttion: 
 */
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
        // 原链表元素放栈里面 先进后出
        Stack<Integer> s1 = this.nodeStack(l1);
        Stack<Integer> s2 = this.nodeStack(l2);
        // 求和结果放在栈里
        Stack<Integer> s = new Stack<>();
        // 求和进位
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int v1 = s1.isEmpty() ? 0 : s1.pop();
            int v2 = s2.isEmpty() ? 0 : s2.pop();
            int sum = v1 + v2 + carry;
            s.push(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) {
            s.push(carry);
        }
        // 串新链表
        ListNode dumy = new ListNode();
        ListNode cur = dumy;
        while (!s.isEmpty()) {
            cur.next = new ListNode(s.pop());
            cur = cur.next;
        }
        return dumy.next;
    }

    private Stack<Integer> nodeStack(ListNode head) {
        Stack<Integer> res = new Stack<>();
        while (head != null) {
            res.push(head.val);
            head = head.next;
        }
        return res;
    }
}
// @lc code=end
