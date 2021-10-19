/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution
{

    private static class BSTInfo
    {
        // 当前树是否是二叉搜索树
        boolean isBST;
        Integer minVal;
        Integer maxVal;
    }

    public boolean isValidBST(TreeNode root)
    {
        // base case
        BSTInfo res = this.dfs(root);
        return res.isBST;
    }

    private BSTInfo dfs(TreeNode root)
    {
        BSTInfo info = new BSTInfo();
        // base case
        if (root == null)
        {
            info.isBST = true;
            return info;
        }
        // left
        BSTInfo left = this.dfs(root.left);
        // right
        BSTInfo right = this.dfs(root.right);
        // merge
        boolean isBst = left.isBST && right.isBST;
        Integer maxVal = null, minVal = null;
        if (left.minVal == null)
        {
            if (right.minVal == null)
            {
                minVal = root.val;
                maxVal = root.val;
            }
            else
            {
                isBst = isBst && (root.val < right.minVal);
                minVal = root.val;
                maxVal = right.maxVal;
            }
        }
        else
        {
            if (right.minVal == null)
            {
                isBst = isBst && (left.maxVal < root.val);
                minVal = left.minVal;
                maxVal = root.val;
            }
            else
            {
                isBst = isBst && (left.maxVal < root.val) && (root.val < right.minVal);
                minVal = Math.min(root.val, Math.min(left.minVal, right.minVal));
                maxVal = Math.max(root.val, Math.max(left.maxVal, right.maxVal));
            }
        }
        info.isBST = isBst;
        info.minVal = minVal;
        info.maxVal = maxVal;
        return info;
    }
}
// @lc code=end
