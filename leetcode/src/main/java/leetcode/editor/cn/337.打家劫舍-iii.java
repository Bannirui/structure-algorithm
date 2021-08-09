import java.util.HashMap;
import java.util.Map;

import leetcode.editor.cn.InvertBinaryTree.TreeNode;

/*
 * @Author: dingRui
 * @Date: 2021-08-09 22:34:38
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-09 22:52:18
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
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
    // 选当前节点
    private Map<TreeNode, Integer> f = new HashMap<>();
    // 不选当前节点
    private Map<TreeNode, Integer> g = new HashMap<>();

    public int rob(TreeNode root) {
        this.dfs(root);
        return Math.max(this.f.getOrDefault(root, 0), this.g.getOrDefault(root, 0));
    }

    private void dfs(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }
        TreeNode l = root.left;
        TreeNode r = root.right;
        this.dfs(l);
        this.dfs(r);
        // 偷 root节点 不偷root的孩子
        this.f.put(root, root.val + this.g.getOrDefault(l, 0) + this.g.getOrDefault(r, 0));
        // 不偷root 偷或者不偷root的孩子
        this.g.put(root, Math.max(f.getOrDefault(l, 0), g.getOrDefault(l, 0))
                + Math.max(f.getOrDefault(r, 0), g.getOrDefault(r, 0)));
    }
}
// @lc code=end
