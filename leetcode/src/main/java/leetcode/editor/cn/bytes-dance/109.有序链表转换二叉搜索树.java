/*
 * @lc app=leetcode.cn id=109 lang=java
 *
 * [109] 有序链表转换二叉搜索树
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return this.dfs(head, null);
    }

    // [head...tail)
    private TreeNode dfs(ListNode head, ListNode tail){
        if(head==tail) return null;
        ListNode slow=head, fast=head;
        while(fast!=tail){
            if(fast.next==tail) break;
            fast=fast.next.next;
            slow=slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left=this.dfs(head, slow);
        root.right=this.dfs(slow.next, tail);
        return root;
    }
}
// @lc code=end

