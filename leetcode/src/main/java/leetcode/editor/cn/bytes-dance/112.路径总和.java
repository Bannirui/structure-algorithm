/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false; // corner condition
        return this.dfs(root, targetSum);
    }

    private boolean dfs(TreeNode root, int targetSum){
        if(root==null){ // base case
            return false;
        }
        int targetSumCpy = targetSum-root.val;
        if(root.left==null && root.right==null && targetSumCpy==0) return true; // the leaf
        return this.dfs(root.left, targetSumCpy) || this.dfs(root.right, targetSumCpy);
    }
}
// @lc code=end

