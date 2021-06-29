/*
 * @Author: dingrui
 * @Date: 2021-06-29 11:47:01
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-29 12:58:21
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=897 lang=java
 *
 * [897] 递增顺序搜索树
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

    private TreeNode resRoot;

    public TreeNode increasingBST(TreeNode root) {
        this.resRoot = new TreeNode();
        // 记录头
        TreeNode res = resRoot;
        dfs(root);
        return res.right;
    }

    // 中序
    public void dfs(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }
        // left
        dfs(root.left);
        // root
        root.left = null;
        this.resRoot.right = root;
        this.resRoot = this.resRoot.right;
        // right
        dfs(root.right);
    }
}
// @lc code=end
