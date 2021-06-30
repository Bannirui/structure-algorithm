
import leetcode.editor.cn.BalancedBinaryTree.TreeNode;

/*
 * @Author: dingrui
 * @Date: 2021-06-30 10:38:46
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-30 13:13:51
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=993 lang=java
 *
 * [993] 二叉树的堂兄弟节点
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
    public boolean isCousins(TreeNode root, int x, int y) {
        // base case
        if (root == null) {
            return false;
        }
        if (root.val == x || root.val == y) {
            return false;
        }
        // 节点 深度 父节点
        CousinsInfo xInfo = dfs(root, x, null, 0);
        CousinsInfo yInfo = dfs(root, y, null, 0);
        // compare
        if (xInfo == null || yInfo == null) {
            return false;
        }
        if (xInfo.height == yInfo.height && xInfo.parent != yInfo.parent) {
            return true;
        }
        return false;
    }

    class CousinsInfo {
        private int height;
        private int parent;

        public CousinsInfo(int height, int parent) {
            this.height = height;
            this.parent = parent;
        }
    }

    /**
     * 
     * @param node 在node树中出发
     * @param v 找节点值等于v
     * @param parent 当前树的父节点
     * @param height 当前树高
     * @return
     */
    public CousinsInfo dfs(TreeNode node, int v, TreeNode parent, int height) {
        // base case
        if (node == null) {
            return null;
        }
        // root
        if (node.val == v) {
            // 整棵树的根节点
            return new CousinsInfo(height, parent.val);
        }
        CousinsInfo left = dfs(node.left, v, node, height + 1);
        CousinsInfo right = dfs(node.right, v, node, height + 1);
        return left == null ? right : left;
    }
}
// @lc code=end
