/*
 * @lc app=leetcode.cn id=572 lang=java
 *
 * [572] 另一棵树的子树
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // base case
        if(root==null ^ subRoot==null){
            return false;
        }
        if(root==null && subRoot==null){
            return true;
        }
        // 都不是null
        return this.isSame(root, subRoot)
        || this.isSubtree(root.left, subRoot) || this.isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode node1, TreeNode node2){
        if(node1==null ^ node2==null){
            return false;
        }
        if(node1==null && node2==null){
            return true;
        }
        // 都不是null
        return node1.val==node2.val && this.isSame(node1.left, node2.left) && this.isSame(node1.right, node2.right);
    }
}
// @lc code=end

