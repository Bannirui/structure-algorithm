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
    
    // 偷某个root节点
    Map<TreeNode, Integer> withMap = new HashMap<>();

    // 不偷某个root节点
    Map<TreeNode, Integer> withoutMap = new HashMap<>();

    public int rob(TreeNode root) {
        this.dfs(root);
        return Math.max(this.withMap.getOrDefault(root,0),this.withoutMap.getOrDefault(root,0));
    }

    private void dfs(TreeNode root){
        // base case
        if(root==null){
            return;
        }
        this.dfs(root.left);
        this.dfs(root.right);
        // 偷root 不能偷子节点
        this.withMap.put(root, root.val+withoutMap.getOrDefault(root.left,0)+withoutMap.getOrDefault(root.right,0));
        // 不偷root 子节点可偷可不偷
        this.withoutMap.put(root, Math.max(withMap.getOrDefault(root.left,0),withoutMap.getOrDefault(root.left,0))+Math.max(withMap.getOrDefault(root.right,0),withoutMap.getOrDefault(root.right,0)));
    }
}
// @lc code=end

