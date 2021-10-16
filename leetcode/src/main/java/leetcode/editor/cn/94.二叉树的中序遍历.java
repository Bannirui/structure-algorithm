import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root)
    {
        this.dfs(root);
        return this.res;
    }

    private void dfs(TreeNode root)
    {
        // base case
        if (root == null)
        {
            return;
        }
        // left-mid-right
        this.dfs(root.left);
        this.res.add(root.val);
        this.dfs(root.right);
    }
}
// @lc code=end
