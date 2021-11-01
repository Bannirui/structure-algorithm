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
        // head->tail 低位->高位 求和的结果 入队列 先进先出
        Deque<Integer> sumQ = new LinkedList<>();
        // 两数求和进位
        int carry=0;
        while(l1!=null || l2!=null){
            int add1=0, add2=0;
            if(l1!=null){
                add1 = l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                add2 = l2.val;
                l2=l2.next;
            }
            int sum = add1+add2+carry;
            carry = sum/10;
            sumQ.offerLast(sum%10);
        }
        // 检查进位
        if(carry!=0){
            sumQ.offerLast(carry);
        }
        // 栈中元素作为链表节点
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(!sumQ.isEmpty()){
            cur.next = new ListNode(sumQ.pollFirst());
            // cur指针后移
            cur = cur.next;
        }
        return dummy.next;
    }
}
// @lc code=end

