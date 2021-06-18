import leetcode.editor.cn.BalancedBinaryTree.TreeNode;

/*
 * @Author: dingrui
 * @Date: 2021-06-18 22:34:11
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-18 22:56:39
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=572 lang=java
 *
 * [572] 另一个树的子树
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // 深度优先
        return dfs(root, subRoot);
    }

    public boolean dfs(TreeNode root, TreeNode subRoot) {
        // base case
        if (root == null) {
            if (subRoot == null) {
                return true;
            } else {
                return false;
            }
        }
        // 比较root跟subRoot是否相等 根-左-右
        return check(root, subRoot) || dfs(root.left, subRoot) || dfs(root.right, subRoot);
    }

    public boolean check(TreeNode root, TreeNode subRoot) {
        // base case
        if (root == null) {
            if (subRoot == null) {
                return true;
            } else {
                return false;
            }
        } else {
            if (subRoot == null) {
                return false;
            } else {
                if (root.val == subRoot.val) {
                    // 当前根节点值相等 递归比较子树
                    return check(root.left, subRoot.left) && check(root.right, subRoot.right);
                } else {
                    return false;
                }
            }
        }
    }
}
// @lc code=end
