/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 */

// @lc code=start
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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true; // base case
        int leftHeight = this.dfsHeight(root.left);
        int rightHeight = this.dfsHeight(root.right);
        return Math.abs(leftHeight-rightHeight)<=1 && this.isBalanced(root.left) && this.isBalanced(root.right);
    }

    private int dfsHeight(TreeNode root){
        if(root==null) return 0; // base case
        int left = this.dfsHeight(root.left);
        int right = this.dfsHeight(root.right);
        return Math.max(left, right) + 1;
    }
}
// @lc code=end


