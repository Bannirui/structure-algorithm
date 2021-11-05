/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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

    private int counts=0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 1;
        }
        this.height(root);
        return this.counts-1;
    }

    // 树高
    private int height(TreeNode root){
        // base case
        if(root==null){
            return 0;
        }
        int l = this.height(root.left);
        int r = this.height(root.right);
        counts = Math.max(counts, l+r+1);
        return Math.max(l, r)+1;
    }
}
// @lc code=end

