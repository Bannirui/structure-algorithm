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
    private int cnt=0;

    public int diameterOfBinaryTree(TreeNode root) {
        // base case
        if(root==null){
            return 0;
        }
        this.getHeight(root);
        return cnt-1;
    }

    private int getHeight(TreeNode root){
        // base case
        if(root==null){
            return 0;
        }
        int lHeight = this.getHeight(root.left);
        int rHeight = this.getHeight(root.right);
        int tmpCnt = lHeight+rHeight+1;
        cnt=Math.max(cnt, tmpCnt);
        return Math.max(lHeight,rHeight)+1;
    }
}
// @lc code=end

