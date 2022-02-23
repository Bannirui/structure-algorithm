/*
 * @lc app=leetcode.cn id=515 lang=java
 *
 * [515] 在每个树行中找最大值
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root==null) return ret;
        Queue<TreeNode> q = new LinkedList<>(){{
            offer(root);
        }};
        while(!q.isEmpty()){
            int size=q.size();
            int tmp = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode cur = q.poll();
                tmp=Math.max(tmp, cur.val);
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
            ret.add(tmp);
        }
        return ret;
    }
}
// @lc code=end

