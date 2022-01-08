/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root==null) return ret;
        this.dfs(root, ret);
        return ret;
    }

    private void dfs(TreeNode root, List<Integer> ret){
        if(root==null) return;
        ret.add(root.val);
        this.dfs(root.left, ret);
        this.dfs(root.right, ret);
    }
}
// @lc code=end

