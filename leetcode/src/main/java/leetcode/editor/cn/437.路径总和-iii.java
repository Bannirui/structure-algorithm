/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
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
    public int pathSum(TreeNode root, int targetSum) {
        // base case
        if(root==null){
            return 0;
        }
        // 选择当前节点 不选择当前节点
        int cnt = 0;
        cnt += this.trace(root, targetSum);
        cnt += this.pathSum(root.left, targetSum);
        cnt += this.pathSum(root.right, targetSum);
        return cnt;
    }

    // 以root为起点 和为targetSum的路径
    private int trace(TreeNode root, int targetSum){
        int cnt=0;
        // base case
        if(root==null){
            return cnt;
        }
        if(targetSum==root.val){
            cnt++;
        }
        cnt += this.trace(root.left, targetSum-root.val);
        cnt += this.trace(root.right, targetSum-root.val);
        return cnt;
    }
}
// @lc code=end

