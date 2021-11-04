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
        // dfs
        // base case
        if(root==null){
            return;
        }
        // root->left->right
        // 把左子树挂到root的右节点 保留root右节点的引用指针 left递归结束挂到left的right指针
        // 保存右子树
        TreeNode right = root.right;
        // 左子树全部展开 将展开后结果挂到右指针
        this.flatten(root.left);
        root.right=root.left;
        root.left=null;
        // 将右子树挂到原来左子树的最后节点右指针上
        while(root.right!=null){
            root=root.right;
        }
        // 展开原来的右子树
        this.flatten(right);
        // 右子树挂到左子树右指针
        root.right=right;
    }
}
// @lc code=end

