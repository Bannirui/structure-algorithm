/*
 * @lc app=leetcode.cn id=1019 lang=java
 *
 * [1019] 链表中的下一个更大节点
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
    public int[] nextLargerNodes(ListNode head) {
        if(head==null) throw new IllegalArgumentException();
        int cnt = this.cnt(head);
        Stack<int[]> stack = new Stack<>();
        int[] ret = new int[cnt];
        ListNode cur = head;
        int idx=0;
        while(cur!=null){
            while(!stack.isEmpty() && cur.val>stack.peek()[1]) {
                int[] pop = stack.pop();
                ret[pop[0]] = cur.val;
            }
            stack.push(new int[]{idx, cur.val});
            cur=cur.next;
            idx++;
        }
        while(!stack.isEmpty()){
            int[] pop = stack.pop();
            ret[pop[0]] = 0;
        }
        return ret;
    }

    private int cnt(ListNode head){
        if(head==null) return 0;
        return 1+this.cnt(head.next);
    }
}
// @lc code=end

