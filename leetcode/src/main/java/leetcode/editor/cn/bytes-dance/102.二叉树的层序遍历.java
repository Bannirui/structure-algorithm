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
        // bfs
        List<List<Integer>> ret = new ArrayList<>();
        if(root==null) return ret; // corner condition
        Deque<TreeNode> q = new LinkedList<>();
        q.offerLast(root);
        while(!q.isEmpty()){
            int size = q.size(); // element cnt for cur level
            List<Integer> tmpList = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode curNode = q.pollFirst();
                tmpList.add(curNode.val);
                if(curNode.left!=null){
                    q.offerLast(curNode.left);
                }
                if(curNode.right!=null){
                    q.offerLast(curNode.right);
                }
            }
            ret.add(tmpList);
        }
        return ret;
    }
}
// @lc code=end

