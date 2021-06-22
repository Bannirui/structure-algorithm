import java.util.Set;

/*
 * @Author: dingrui
 * @Date: 2021-06-22 14:40:59
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-22 15:20:17
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=653 lang=java
 *
 * [653] 两数之和 IV - 输入 BST
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
    public boolean findTarget(TreeNode root, int k) {
        // base case
        if (root == null) {
            return false;
        }
        Set<Integer> cache = new HashSet<>();
        return dfs(root, k, cache);
    }

    public boolean dfs(TreeNode root, int remain, Set<Integer> cache) {
        // base case
        if (root == null) {
            return false;
        }
        // root
        if (cache.contains(remain - root.val)) {
            return true;
        }
        cache.add(root.val);
        return dfs(root.left, remain, cache) || dfs(root.right, remain, cache);
    }
}
// @lc code=end
