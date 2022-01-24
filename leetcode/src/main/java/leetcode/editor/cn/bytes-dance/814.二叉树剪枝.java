/*
 * @lc app=leetcode.cn id=814 lang=java
 *
 * [814] 二叉树剪枝
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
    public TreeNode pruneTree(TreeNode root) {
        return this.childContains1(root)?root:null;
    }

    private boolean childContains1(TreeNode root){
        if(root==null) return false;
        boolean leftContains1 = this.childContains1(root.left);
        boolean rightContains1 = this.childContains1(root.right);
        if(!leftContains1) root.left=null;
        if(!rightContains1) root.right=null;
        return root.val==1||leftContains1||rightContains1;
    }
}
// @lc code=end

