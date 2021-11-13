/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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

    private static class Info{
        private boolean isBalance;
        private int lHeight;
        private int rHeight;

        public Info(boolean isBalance, int lHeight, int rHeight){
            this.isBalance=isBalance;
            this.lHeight=lHeight;
            this.rHeight=rHeight;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return this.dfs(root).isBalance;
    }

    private Info dfs(TreeNode root){
        // base case
        if(root==null){
            return new Info(true, 0, 0);
        }
        Info l = this.dfs(root.left);
        Info r = this.dfs(root.right);
        boolean isBalance=false;
        if(l.isBalance&&r.isBalance){
            isBalance=true;
        }
        int lHeight = Math.max(l.lHeight, l.rHeight)+1;
        int rHeight = Math.max(r.lHeight, r.rHeight)+1;
        isBalance = isBalance&&Math.abs(lHeight-rHeight)<=1;
        return new Info(isBalance, lHeight, rHeight);
    }
}
// @lc code=end

