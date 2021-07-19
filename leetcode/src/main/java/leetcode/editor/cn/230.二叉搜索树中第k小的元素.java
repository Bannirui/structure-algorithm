import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import leetcode.editor.cn.InvertBinaryTree.TreeNode;

/*
 * @Author: dingrui
 * @Date: 2021-07-19 23:18:54
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-19 23:39:02
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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

    List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        // 中序
        this.dfs(root);
        return this.list.get(k - 1);
    }

    private void dfs(TreeNode node) {
        // base case
        if (node == null) {
            return;
        }
        if (node.left != null) {
            dfs(node.left);
        }
        // 加到堆
        this.list.add(node.val);
        if (node.right != null) {
            dfs(node.right);
        }
    }
}
// @lc code=end
