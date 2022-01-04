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
        if(root==null && subRoot==null) return true;
        if(root==null ^ subRoot==null) return false;
        return this.compareByDfs(root, subRoot) || this.isSubtree(root.left, subRoot) || this.isSubtree(root.right, subRoot);
    }

    // if the same for each node, return true
    // otherwise, return false
    private boolean compareByDfs(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null) return true;
        if(root1==null ^ root2==null) return false;
        if(root1.val!=root2.val) return false;
        return this.compareByDfs(root1.left, root2.left) && this.compareByDfs(root1.right, root2.right);
    }
}
// @lc code=end

