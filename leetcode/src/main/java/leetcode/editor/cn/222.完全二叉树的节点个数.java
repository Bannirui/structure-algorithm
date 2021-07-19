import javax.swing.text.AbstractDocument.LeafElement;

/*
 * @Author: dingrui
 * @Date: 2021-07-19 09:39:37
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-19 10:39:36
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // root从第一层出发到mostLeft层的节点数
        return dfs(root, 1, this.getMostLeft(root, 1));
    }

    // 树以node为根 start...height层 节点数
    private int dfs(TreeNode node, int start, int height) {
        // base case
        if (start == height) {
            return 1;
        }
        // 完全二叉树 数高=h 节点数=(2^h)-1
        if (this.getMostLeft(node.right, start + 1) == height) {
            // 左数是完全二叉树
            return ((1 << (height - start)) - 1) + 1 + dfs(node.right, start + 1, height);
        } else {
            // 右树是完全二叉树
            return dfs(node.left, start + 1, height) + 1 + ((1 << (height - start - 1)) - 1);
        }
    }

    // 递归求树高 最左子树的高度
    // root: 当前节点
    // start: 当前节点高度
    private int getMostLeft(TreeNode root, int start) {
        // base case
        while (root != null) {
            start++;
            root = root.left;
        }
        return start - 1;
    }
}
// @lc code=end
