/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution
{
    public int maxDepth(TreeNode root)
    {
        return this.dfs(root, 0);
    }

    private int dfs(TreeNode node, int height)
    {
        // base case
        if (node == null)
        {
            return height;
        }
        return Math.max(this.dfs(node.left, height), this.dfs(node.right, height)) + 1;
    }
}
// @lc code=end
