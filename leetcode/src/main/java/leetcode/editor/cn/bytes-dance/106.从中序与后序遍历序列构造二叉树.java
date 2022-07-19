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

    private TreeNode dfs(int[] inorder, int is, int ie, int[] postorder, int ps, int pe){
        if(ps>pe) return null;
        if(ps==pe) return new TreeNode(postorder[pe]);
        // post [ps...pe]
        TreeNode root = new TreeNode(postorder[pe]);
        int rootIdx4Inorder = this.findIdx4Inorder(inorder, postorder[pe]);
        if(rootIdx4Inorder==-1) throw new IllegalArgumentException();
        // left inorder [is...idx)
        // right inorder (idx...ie]
        root.left = this.dfs(inorder, is, rootIdx4Inorder-1, postorder, ps, (rootIdx4Inorder-1-is)+ps);
        root.right = this.dfs(inorder, rootIdx4Inorder+1, ie, postorder, (pe-1)-(ie-(rootIdx4Inorder+1)), pe-1);
        return root;
    }

    private int findIdx4Inorder(int[] inorder, int target){
        int len=0;
        if(inorder==null || (len=inorder.length)==0) throw new IllegalArgumentException();
        int ret=-1;
        for(int i=0;i<len;i++){
            if(inorder[i]==target) return i;
        }
        return ret;
    }
}
// @lc code=end

