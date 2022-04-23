/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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
    public void flatten(TreeNode root) {
        root = this.dfs(root);
    }

    private TreeNode dfs(TreeNode root)
    {
        if(root==null) return root;
        TreeNode left = this.dfs(root.left);
        TreeNode right = this.dfs(root.right);
        if(left!=null)
        {
            root.left=null;
            root.right=left;
            // 左子树最后节点后面挂上右子树
            TreeNode mostRight = left;
            while(mostRight!=null) {
                if(mostRight.right==null) break;
                mostRight=mostRight.right;
            }
            mostRight.right=right;
        }
        return root;
    }
}
// @lc code=end

