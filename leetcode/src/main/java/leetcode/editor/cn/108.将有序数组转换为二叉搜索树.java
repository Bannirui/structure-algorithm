/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution
{
    public TreeNode sortedArrayToBST(int[] nums)
    {
        return this.dfs(nums, 0, nums.length - 1);
    }

    // nums [start...end]递归创建平衡搜索二叉树 中间靠左的位置作为root
    private TreeNode dfs(int[] nums, int start, int end)
    {
        // base case
        if (start > end)
        {
            return null;
        }
        int mid = start + ((end - start) >>> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = this.dfs(nums, start, mid - 1);
        root.right = this.dfs(nums, mid + 1, end);
        return root;
    }
}
// @lc code=end
