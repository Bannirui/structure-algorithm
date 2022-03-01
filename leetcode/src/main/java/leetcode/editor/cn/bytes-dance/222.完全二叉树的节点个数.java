/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
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
    public int countNodes(TreeNode root) {
        // base case
        if(root==null) return 0;
        return this.countNodes(root,this.mostLeftHeight(root,1), 1);
    }

    private int countNodes(TreeNode root, int totalHeight, int curHeight){
        if(curHeight==totalHeight) return 1;
        if(this.mostLeftHeight(root.right, curHeight+1)==totalHeight) return (1<<(totalHeight-curHeight))-1+1+this.countNodes(root.right,totalHeight,curHeight+1);
        else return (1<<(totalHeight-curHeight-1))-1+1+this.countNodes(root.left, totalHeight, curHeight+1);
    }

    private int mostLeftHeight(TreeNode root, int curHeight){
        while(root!=null){
            curHeight++;
            root=root.left;
        }
        return curHeight-1;
    }
}
// @lc code=end

