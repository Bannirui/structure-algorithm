/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return this.dfs(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode dfs(int[] in, int inL, int inR, int[] post, int postL, int postR){
        // base case
        if(inL>inR || postL>postR){
            return null;
        }
        // 中序 l-root-r
        // 后序 l-r-root
        // root
        TreeNode root = new TreeNode(post[postR]);
        int rootIdxInInorder = this.findIdxInInorder(in, inL, inR, post[postR]);
        // 左树 in[l...idx-1]
        // 右树 in[idx+1...r]
        TreeNode l = this.dfs(in,inL,rootIdxInInorder-1,post,postL,postL+(rootIdxInInorder-1-inL)); 
        TreeNode r = this.dfs(in,rootIdxInInorder+1,inR,post,postL+(rootIdxInInorder-1-inL)+1,postR-1);
        root.left=l;
        root.right=r;
        return root;
    }

    // 中序[l...r]中找target的脚标
    private int findIdxInInorder(int[] in, int inL, int inR, int target){
        for(int i=inL; i<=inR;i++){
            if(in[i]==target){
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

