/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层序遍历 II
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root==null) return ret;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Stack<List<Integer>> s = new Stack<>();
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode cur = q.poll();
                l.add(cur.val);
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
            s.push(l);
        }
        while(!s.isEmpty()) ret.add(s.pop());
        return ret;
    }
}
// @lc code=end

