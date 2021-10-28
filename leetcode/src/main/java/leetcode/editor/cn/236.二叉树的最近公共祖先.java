/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null) {
            return null;
        }
        if (p == root) {
            return root;
        }
        if (q == root) {
            return root;
        }
        // 左树上找p和q的公共祖先
        TreeNode left = this.lowestCommonAncestor(root.left, p, q);
        // 右树上找p和q的公共祖先
        TreeNode right = this.lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else {
            return left != null ? left : right;
        }
    }
}
// @lc code=end
