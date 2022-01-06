/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0) return null;
        return this.dfs(nums, 0, nums.length-1);
    }

    private TreeNode dfs(int[] nums, int l, int r){
        if(l>r) return null;
        int mid = l+((r-l)>>1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = this.dfs(nums, l, mid-1);
        root.right = this.dfs(nums, mid+1, r);
        return root;
    }
}
// @lc code=end

