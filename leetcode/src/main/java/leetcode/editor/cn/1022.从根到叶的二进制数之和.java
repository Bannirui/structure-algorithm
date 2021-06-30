import java.util.ArrayList;
import java.util.List;

import leetcode.editor.cn.BalancedBinaryTree.TreeNode;

/*
 * @Author: dingrui
 * @Date: 2021-06-30 16:30:32
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-30 16:56:05
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1022 lang=java
 *
 * [1022] 从根到叶的二进制数之和
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

    private int sum;

    public int sumRootToLeaf(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return this.sum;
    }

    private void dfs(TreeNode node, int pathSum) {
        // base case
        if (node == null) {
            return;
        }
        // root
        pathSum = (pathSum << 1) + node.val;
        if (node.left == null && node.right == null) {
            this.sum += pathSum;
        }
        // left
        dfs(node.left, pathSum);
        // right
        dfs(node.right, pathSum);
    }
}
// @lc code=end
