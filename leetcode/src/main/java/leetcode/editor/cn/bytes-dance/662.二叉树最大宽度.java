/*
 * @lc app=leetcode.cn id=662 lang=java
 *
 * [662] 二叉树最大宽度
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

    int maxLen;
    Map<Integer, Integer> firIdx4Level = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        this.maxLen=0;
        this.dfs(root, 0, 0);
        return maxLen;
    }

    private void dfs(TreeNode root, int level, int idx){
        if(root==null) return;
        if(!this.firIdx4Level.containsKey(level)) this.firIdx4Level.put(level, idx);
        this.maxLen = Math.max(this.maxLen, idx-this.firIdx4Level.get(level)+1);
        this.dfs(root.left, level+1, idx*2);
        this.dfs(root.right, level+1, idx*2+1);
    }
}
// @lc code=end

