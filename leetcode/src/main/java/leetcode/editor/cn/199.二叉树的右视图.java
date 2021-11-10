/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
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
    public List<Integer> rightSideView(TreeNode root) {
        // 结果集
        List<Integer> res = new ArrayList<>();
        // 层序 从左往右添加节点
        if(root==null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            // 层
            int size = q.size();
            for(int i=0; i<size; i++){
                // 当层最右节点
                TreeNode curNode = q.poll();
                if(i==(size-1)){
                    res.add(curNode.val);
                }
                // 子节点入队
                if(curNode.left!=null){
                    q.offer(curNode.left);
                }
                if(curNode.right!=null){
                    q.offer(curNode.right);
                }
            }
        }
        return res;
    }
}
// @lc code=end

