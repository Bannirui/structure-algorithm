/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根节点到叶节点数字之和
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

    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        return this.sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int preSum){
        if(root==null) return 0; // base case
        int curSum = (preSum*10 + root.val);
        if(root.left==null&&root.right==null){
            return curSum;
        }
        return this.sumNumbers(root.left, curSum) + this.sumNumbers(root.right, curSum);
    }
}
// @lc code=end

