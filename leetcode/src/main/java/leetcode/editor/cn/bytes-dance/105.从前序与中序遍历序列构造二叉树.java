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

    private static final Map<Integer, Integer> inVal2Idx = new HashMap<>(); // for inorder: key=val value=idx

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int pLen=0, iLen=0;
        if(preorder==null||inorder==null||(pLen=preorder.length)==0||(iLen=inorder.length)==0) return null; // corner condition
        for(int i=0; i<iLen; i++){ // iterator
            inVal2Idx.put(inorder[i], i);
        }
        return this.buildTree(preorder, 0, pLen-1, inorder, 0, iLen-1);
    }

    private TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie){
        if(ps>pe || is>ie) return null; // base case
        int rootVal = preorder[ps];
        TreeNode root = new TreeNode(rootVal);
        if(!inVal2Idx.containsKey(rootVal)){
            throw new RuntimeException("error: param error");
        }
        int idx = inVal2Idx.get(rootVal);
        TreeNode left = this.buildTree(preorder, ps+1, ps+1+(idx-is-1), inorder, is, idx-1);
        TreeNode right = this.buildTree(preorder, ps+1+(idx-is-1)+1, pe, inorder, idx+1, ie);
        root.left = left;
        root.right = right;
        return root;
    }
}
// @lc code=end

