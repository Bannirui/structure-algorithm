/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    private int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root)
    {
        this.dfs(root);
        return this.sum;
    }

    private int dfs(TreeNode root)
    {
        // base case
        if (root == null)
        {
            return 0;
        }
        int left = Math.max(this.dfs(root.left), 0);
        int right = Math.max(this.dfs(root.right), 0);
        // 2种情况 子树不包含根节点 包含根节点
        this.sum = Math.max(this.sum, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
// @lc code=end
