/*
 * @lc app=leetcode.cn id=958 lang=java
 *
 * [958] 二叉树的完全性检验
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
    public boolean isCompleteTree(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leaf=false;
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            TreeNode left=cur.left;
            TreeNode right=cur.right;
            if((leaf&&(left!=null||right!=null))||(left==null&&right!=null)) return false;
            if(left!=null) q.offer(left);
            if(right!=null) q.offer(right);
            else leaf=true;
        }
        return true;
    }
}
// @lc code=end

