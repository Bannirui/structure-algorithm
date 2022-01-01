/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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

    private List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.dfs(root, targetSum, new ArrayList<>());
        return this.ret;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> path){
        if(root==null) return; // base case
        List<Integer> pathCpy = new ArrayList<>(path);
        pathCpy.add(root.val);
        int targetSumCpy = targetSum-root.val;
        if(root.left==null && root.right==null && targetSumCpy==0){
            this.ret.add(new ArrayList<>(pathCpy));
        }
        this.dfs(root.left, targetSumCpy, pathCpy);
        this.dfs(root.right, targetSumCpy, pathCpy);
    }
}
// @lc code=end

