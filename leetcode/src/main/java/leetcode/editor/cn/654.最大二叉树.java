/*
 * @Author: dingrui
 * @Date: 2021-07-17 16:34:52
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-17 16:54:46
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return this.dfs(nums, 0, nums.length - 1);
    }

    // nums[start...end]最大额二叉树
    private TreeNode dfs(int[] nums, int start, int end) {
        // base case
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        // 最大值
        int indexOfMaxVal = this.indexOfMaxVal(nums, start, end);
        TreeNode head = new TreeNode(nums[indexOfMaxVal]);
        head.left = dfs(nums, start, indexOfMaxVal - 1);
        head.right = dfs(nums, indexOfMaxVal + 1, end);
        return head;
    }

    // 数组中nums[start...end]最大值的脚标
    private int indexOfMaxVal(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        int preIndex = -1;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                preIndex = i;
            }
        }
        return preIndex;
    }
}
// @lc code=end
