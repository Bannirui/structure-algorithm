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
        if(root==null){
            return 0;
        }
        // root层数
        int level=this.getMostLeftHeight(root, 1);
        return dfsCnt(root, 1, level);
    }

    // 以root为根节点的完全二叉树节点数量
    private int dfsCnt(TreeNode root, int curL, int allL){
        // base case
        if(curL==allL){
            return 1;
        }
        // 右树层数
        int rightLevel = this.getMostLeftHeight(root.right, curL+1);
        if(rightLevel==allL){
            // 左子树是满二叉树
            int left = (1<<(allL-curL))-1;
            int right = this.dfsCnt(root.right, curL+1, allL);
            return left+1+right;
        }else{
            // 右子树是满二叉树
            int left = this.dfsCnt(root.left, curL+1, allL);
            int right= (1<<(allL-curL-1))-1;
            return left + 1+right;
        }
    }

    // 树最左节点高度
    private int getMostLeftHeight(TreeNode root, int level){
        while(root!=null){
            level++;
            root=root.left;
        }
        return level-1;
    }
}
// @lc code=end

