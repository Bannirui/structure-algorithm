/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==null||q==null) throw new IllegalArgumentException();
        if(root==null) return null;
        if(p.val<root.val && q.val<root.val) return this.lowestCommonAncestor(root.left, p, q);
        else if(p.val>root.val && q.val>root.val) return this.lowestCommonAncestor(root.right, p, q);
        else return root;
    }
}
// @lc code=end

