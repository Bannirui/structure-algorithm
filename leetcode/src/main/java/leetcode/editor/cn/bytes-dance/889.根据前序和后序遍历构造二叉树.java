/*
 * @lc app=leetcode.cn id=889 lang=java
 *
 * [889] 根据前序和后序遍历构造二叉树
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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // root-left-right
        // left-right-root
        int lenPre=0, lenPost=0;
        if(preorder==null || postorder==null) throw new IllegalArgumentException();
        if((lenPre=preorder.length)!=(lenPost=postorder.length)) throw new IllegalArgumentException();
        if(lenPre==0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        if(lenPre==1) return root;
        int cntOfLeftRoot = 0;
        for(int i=0;i<lenPost;i++){
            // 左子树的起点肯定是前序紧随着root的节点
            if(preorder[1]==postorder[i]) cntOfLeftRoot=i+1;
        }
        root.left=this.constructFromPrePost(Arrays.copyOfRange(preorder, 1, cntOfLeftRoot+1), Arrays.copyOfRange(postorder, 0, cntOfLeftRoot));
        root.right=this.constructFromPrePost(Arrays.copyOfRange(preorder, cntOfLeftRoot+1, lenPre), Arrays.copyOfRange(postorder, cntOfLeftRoot,lenPost-1));
        return root;
    }
}
// @lc code=end

