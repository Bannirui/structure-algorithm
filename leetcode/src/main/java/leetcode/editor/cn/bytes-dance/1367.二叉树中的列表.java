/*
 * @lc app=leetcode.cn id=1367 lang=java
 *
 * [1367] 二叉树中的列表
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        // base case
        if(head==null && root==null) return true;
        if(head==null) return true;
        if(root==null) return false;
        return this.isSame(head,root) || this.isSubPath(head,root.left) ||this.isSubPath(head,root.right);
    }

    private boolean isSame(ListNode head, TreeNode root){
        // base case
        if(head==null && root==null) return true;
        if(head==null) return true;
        if(root==null) return false;
        return head.val==root.val && (this.isSame(head.next, root.left)||this.isSame(head.next,root.right));
    }
}
// @lc code=end

