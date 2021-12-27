/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return this.bfs(root);
    }

    private List<List<Integer>> bfs(TreeNode root){
        List<List<Integer>> ret = new ArrayList<>();
        if(root==null){
            return ret;
        }
        // deque
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offerLast(root);
        // sort for level
        boolean l2r = true;
        while(!dq.isEmpty()){
            // level by level
            int curLevelSize = dq.size();
            Deque<Integer> levelRet = new LinkedList<>();
            for(int i=0;i<curLevelSize;i++){
                TreeNode curNode = dq.pollFirst();
                if(l2r){
                    levelRet.offerLast(curNode.val);
                }else{
                    levelRet.offerFirst(curNode.val);
                }
                if(curNode.left!=null){
                    dq.offerLast(curNode.left);
                }
                if(curNode.right!=null){
                    dq.offerLast(curNode.right);
                }
            }
            ret.add(new ArrayList<>(levelRet));
            // direction for level
            l2r = !l2r;
        }
        return ret;
    }
}
// @lc code=end

