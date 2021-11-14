/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return this.dfs(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode dfs(int[] pre, int preL, int preR, int[] in, int inL, int inR){
        // base case
        if(preL>preR || inL>inR){
            return null;
        }
        // 前序 root->l->r
        // 中序 l->root->r
        TreeNode root = new TreeNode(pre[preL]);
        // root在中序中的脚标
        int idx=findIdxInInorder(in, inL, inR, pre[preL]);
        TreeNode l=this.dfs(pre, preL+1, preL+1+(idx-1-inL), in, inL, idx-1);
        TreeNode r=this.dfs(pre, preL+1+(idx-1-inL)+1, preR, in, idx+1 , inR);
        root.left=l;
        root.right=r;
        return root;
    }

    private int findIdxInInorder(int[] in, int inL, int inR, int target){
        for(int i=inL;i<=inR;i++){
            if(in[i]==target){
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

