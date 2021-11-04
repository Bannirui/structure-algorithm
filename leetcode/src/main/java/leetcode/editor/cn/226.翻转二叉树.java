/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
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
    public TreeNode invertTree(TreeNode root) {
        // base case
        if(root==null){
            return null;
        }
        TreeNode originLeft = root.left;
        TreeNode originRight = root.right;
        TreeNode newLeft = this.invertTree(originLeft);
        TreeNode newRight = this.invertTree(originRight);
        root.left=newRight;
        root.right=newLeft;
        return root;
    }
}
// @lc code=end

