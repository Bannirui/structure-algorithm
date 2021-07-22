import leetcode.editor.cn.InvertBinaryTree.TreeNode;

/*
 * @Author: dingrui
 * @Date: 2021-07-22 18:12:43
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-22 18:19:31
 * @Descripttion: 
 */
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

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        this.dfs(root, 0);
        return this.sum;
    }

    private void dfs(TreeNode node, int path) {
        // base case
        if (node != null && node.left == null && node.right == null) {
            // 到了叶子节点 收集沿途答案
            this.sum += (path * 10 + node.val);
            return;
        }
        int copyPath = path * 10 + node.val;
        if (node.left != null) {
            dfs(node.left, copyPath);
        }
        if (node.right != null) {
            dfs(node.right, copyPath);
        }
    }
}
// @lc code=end
