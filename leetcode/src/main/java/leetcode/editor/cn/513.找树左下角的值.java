/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
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

    private int tmpDepth=0;
    private int tmpVal=0;

    public int findBottomLeftValue(TreeNode root) {
        this.dfs(root, 0);
        return this.tmpVal;
    }

    // 第n层
    private void dfs(TreeNode root, int depth){
        // base case
        if(root==null){
            return;
        }
        if(depth>=this.tmpDepth){
            // 更新
            this.tmpDepth=depth;
            this.tmpVal=root.val;
        }
        // 右树
        this.dfs(root.right, depth+1);
        // 左树
        this.dfs(root.left, depth+1);
    }
}
// @lc code=end

