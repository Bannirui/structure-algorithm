/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    public int pathSum(TreeNode root, int targetSum) {
        // base case
        if (root == null) {
            return 0;
        }
        return this.dfs(root, targetSum) + this.pathSum(root.left, targetSum) + this.pathSum(root.right, targetSum);
    }

    private int dfs(TreeNode root, int targetSum) {
        // base case
        if (root == null) {
            return 0;
        }
        int tmpCount = 0;
        targetSum -= root.val;
        if (targetSum == 0) {
            tmpCount++;
        }
        return tmpCount + this.dfs(root.left, targetSum) + this.dfs(root.right, targetSum);
    }
}
// @lc code=end
