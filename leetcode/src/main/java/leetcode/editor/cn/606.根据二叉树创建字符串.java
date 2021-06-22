/*
 * @Author: dingrui
 * @Date: 2021-06-21 17:18:19
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-22 10:43:23
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=606 lang=java
 *
 * [606] 根据二叉树创建字符串
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
    public String tree2str(TreeNode root) {
        // 前序遍历 根-左-右 一棵子树一对括号 空节点一对括号 最后删除整棵树的最外层一对括号
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        // base case
        if (root == null) {
            return;
        }
        if (root.left == null) {
            if (root.right == null) {
                // 没有子树
                sb.append(root.val);
                return;
            } else {
                // 只有右树
                sb.append(root.val);
                sb.append("()");
                // 右
                sb.append("(");
                dfs(root.right, sb);
                sb.append(")");
            }
        } else {
            if (root.right == null) {
                // 只有左树
                sb.append(root.val);
                sb.append("(");
                dfs(root.left, sb);
                sb.append(")");
            } else {
                // 左右子树
                sb.append(root.val);
                sb.append("(");
                dfs(root.left, sb);
                sb.append(")");
                sb.append("(");
                dfs(root.right, sb);
                sb.append(")");
            }
        }

    }
}
// @lc code=end
