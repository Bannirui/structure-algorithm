/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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

    private int cnt;
    private int val=-1;

    public int kthSmallest(TreeNode root, int k) {
        this.cnt=k;
        this.dfsMid(root);
        return this.val;
    }

    private void dfsMid(TreeNode root){
        if(root==null || this.cnt<=0) return;
        dfsMid(root.left);
        if(this.cnt>0) {
            this.val=root.val;
            this.cnt--;
        };
        dfsMid(root.right);
    }
}
// @lc code=end

