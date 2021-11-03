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

    private boolean isSymmetric(TreeNode l, TreeNode r){
        if(l==null&&r==null){
            return true;
        }
        // 至少一个不是null
        if(l!=null&&r!=null){
            return l.val==r.val&&this.isSymmetric(l.left, r.right)&&this.isSymmetric(l.right,r.left);
        }else{
            // 只有一个是null
            return false;
        }
    }
}
// @lc code=end

