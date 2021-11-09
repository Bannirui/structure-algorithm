/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 左->右
        List<List<Integer>> res = new ArrayList<>();
        // 入队节点不为空
        if(root==null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            // 当前层节点数
            int curCnt = q.size();
            List<Integer> curLevel = new ArrayList<>();
            for(int i=0; i<curCnt; i++){
                TreeNode curNode = q.poll();
                curLevel.add(curNode.val);
                if(curNode.left!=null){
                    // 左节点入队
                    q.offer(curNode.left);
                }
                if(curNode.right!=null){
                    // 右节点入队
                    q.offer(curNode.right);
                }
            }
            // 当层元素收集结束
            res.add(curLevel);
        }
        return res;
    }
}
// @lc code=end

