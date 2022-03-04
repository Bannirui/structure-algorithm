/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
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
    public int sumOfLeftLeaves(TreeNode root) {
        // base case
        if(root==null) return 0;
        int ret=0;
        if(root.left!=null){
            if(this.isLeaf(root.left)) ret+=root.left.val;
            else ret+=this.sumOfLeftLeaves(root.left);
        }
        if(root.right!=null) {
            if(!this.isLeaf(root.right)) ret+=this.sumOfLeftLeaves(root.right);
        }
        return ret;
    }

    private boolean isLeaf(TreeNode root){
        if(root==null) return false;
        if(root.left==null && root.right==null) return true;
        return false;
    }
}
// @lc code=end

