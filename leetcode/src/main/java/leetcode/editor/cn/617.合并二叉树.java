/*
 * @lc app=leetcode.cn id=617 lang=java
 *
 * [617] 合并二叉树
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // dfs
        return dfs(root1, root2);
    }

    public TreeNode dfs(TreeNode root1, TreeNode root2) {
        // base case
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode merge = new TreeNode();
        merge.val = (root1.val + root2.val);
        merge.left = dfs(root1.left, root2.left);
        merge.right = dfs(root1.right, root2.right);
        return merge;
    }
}
// @lc code=end
