import java.util.HashMap;
import java.util.Map;

/*
 * @Author: dingRui
 * @Date: 2021-08-17 13:51:56
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-17 14:36:35
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=382 lang=java
 *
 * [382] 链表随机节点
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

    private Map<Integer, Integer> index2Val;
    private int size;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.size = 0;
        this.index2Val = new HashMap<>();
        while (head != null) {
            this.index2Val.put(this.size++, head.val);
            head = head.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        if (this.index2Val.isEmpty()) {
            // 空容器
            throw new RuntimeException();
        }
        int random = (int) (Math.random() * this.size);
        return this.index2Val.get(random);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
// @lc code=end
