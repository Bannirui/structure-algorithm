/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
    public boolean isSymmetric(TreeNode root) {
        return this.isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null) return true;
        if(root1==null ^ root2==null) return false;
        return root1.val==root2.val && this.isSymmetric(root1.left, root2.right) && this.isSymmetric(root1.right, root2.left);
    }
}
// @lc code=end

