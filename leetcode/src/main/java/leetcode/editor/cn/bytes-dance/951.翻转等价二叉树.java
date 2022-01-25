/*
 * @lc app=leetcode.cn id=951 lang=java
 *
 * [951] 翻转等价二叉树
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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==root2) return true;
        if(root1==null||root2==null||root1.val!=root2.val) return false;
        return (this.flipEquiv(root1.left,root2.left)&&this.flipEquiv(root1.right,root2.right)) || (this.flipEquiv(root1.left,root2.right)&&this.flipEquiv(root1.right,root2.left));
    }
}
// @lc code=end

