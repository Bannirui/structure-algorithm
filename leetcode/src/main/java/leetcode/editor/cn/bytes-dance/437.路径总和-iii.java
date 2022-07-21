/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        int ret = this.dfs(root, (long)targetSum);
        ret += this.pathSum(root.left, targetSum);
        ret += this.pathSum(root.right, targetSum);
        return ret;
    }

    private int dfs(TreeNode root, long targetSum){
        if(root == null) return 0;
        int ret=0;
        long remain = targetSum-root.val;
        if(remain==0) ret++;
        ret += this.dfs(root.left, remain);
        ret += this.dfs(root.right, remain);
        return ret;
    }
}
// @lc code=end

