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
        return this.buildDfs(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    // 没有重复元素
    private TreeNode buildDfs(int[] preorder, int preL,int preR, int[] inorder, int inL, int inR){
        // bae case
        if(preL>preR||inL>inR){
            return null;
        }
        // root
        TreeNode root = new TreeNode();
        root.val=preorder[preL];
        // 找到root节点在中序中的脚标
        int rootIdx4Inorder = this.findIdx4Inorder(inorder, inL, inR, preorder[preL]);
        // left
        // 前序 [preL+1...preL+1+idx-1-inL]
        // 中序 [inL...idx-1]
        root.left =this.buildDfs(preorder,preL+1,preL+rootIdx4Inorder-inL,inorder,inL, rootIdx4Inorder-1); 
        // right
        // 前序 [preL+1+idx-1-inL+1...preR]
        // 中序 [idx+1...inR]
        root.right=this.buildDfs(preorder,preL+1+rootIdx4Inorder-inL,preR,inorder,rootIdx4Inorder+1,inR);
        return root;
    }

    private int findIdx4Inorder(int[] inorder,int start, int end, int target){
        for(int i=start;i<=end;i++){
            if(inorder[i]==target){
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

