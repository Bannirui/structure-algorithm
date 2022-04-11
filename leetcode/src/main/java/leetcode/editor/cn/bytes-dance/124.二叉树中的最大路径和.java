/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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

    int maxSum=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        this.postOrder(root);
        return this.maxSum;
    }

    // 以root为根节点 必定经过root 最大路径和
    private int postOrder(TreeNode root){
        if(root==null) return 0;
        int left=Math.max(this.postOrder(root.left),0);
        int right=Math.max(this.postOrder(root.right),0);
        this.maxSum = Math.max(left+right+root.val, this.maxSum);
        return root.val+Math.max(left, right);
    }
}
// @lc code=end

