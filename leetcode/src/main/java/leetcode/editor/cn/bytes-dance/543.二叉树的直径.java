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

    private int ret = 1;

    public int diameterOfBinaryTree(TreeNode root) {
        this.dfs(root);
        return this.ret-1;
    }

    private int dfs(TreeNode root){
        if(root==null) return 0;
        int l = this.dfs(root.left);
        int r = this.dfs(root.right);
        this.ret = Math.max(this.ret, l+r+1);
        return Math.max(l, r)+1;
    }
}
// @lc code=end

