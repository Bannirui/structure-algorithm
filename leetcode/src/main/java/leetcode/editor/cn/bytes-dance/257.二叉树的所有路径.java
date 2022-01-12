/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
    
    List<String> ret = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null) return this.ret;
        this.dfs(root, "");
        return this.ret;
    }

    private void dfs(TreeNode root, String path){
        if(root==null) return;
        // cur node root
        String pathCpy = new String(path);
        pathCpy = pathCpy+root.val;
        if(root.left==null && root.right==null) this.ret.add(new String(pathCpy));
        pathCpy+="->";
        this.dfs(root.left, pathCpy);
        this.dfs(root.right, pathCpy);
    }
}
// @lc code=end

