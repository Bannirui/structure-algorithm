/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
    public boolean isSymmetric(TreeNode root)
    {
        return this.check(root, root);
    }

    private boolean check(TreeNode node1, TreeNode node2)
    {
        if (node1 == null && node2 == null)
        {
            return true;
        }
        if (node1 == null || node2 == null)
        {
            return false;
        }
        return node1.val == node2.val && this.check(node1.left, node2.right) && this.check(node1.right, node2.left);
    }
}
// @lc code=end
