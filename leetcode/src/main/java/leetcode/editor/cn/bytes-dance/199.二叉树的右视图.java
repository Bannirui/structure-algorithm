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
        // bfs
        // return this.bfs(root);

        // dfs
        return this.dfs(root);
    }

    private List<Integer> dfs(TreeNode root){
        List<Integer> ret = new ArrayList<>();
        if(Objects.isNull(root)){
            return ret;
        }
        // cache the most right node for each level
        // key=level value=node's val
        Map<Integer, Integer> cacheNode4Level = new HashMap<>();
        // max level which begin with 0
        int maxHeight=0;

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> heightStack = new Stack<>();
        // init
        nodeStack.push(root);
        heightStack.push(0);
        while(!nodeStack.isEmpty()){
            TreeNode curNode = nodeStack.pop();
            Integer curHeight = heightStack.pop();
            if(Objects.nonNull(curNode)){
                maxHeight = Math.max(maxHeight, curHeight);
                if(!cacheNode4Level.containsKey(curHeight)){
                    // first element is the most right node
                    cacheNode4Level.put(curHeight, curNode.val);
                }
                // push children
                nodeStack.push(curNode.left);
                heightStack.push(curHeight+1);
                nodeStack.push(curNode.right);
                heightStack.push(curHeight+1);
            }
        }
        for(int i=0;i<=maxHeight;i++){
            ret.add(cacheNode4Level.get(i));
        }
        return ret;
    }

    private List<Integer> bfs(TreeNode root){
        if(root==null){
            return Collections.emptyList();
        }
        List<Integer> ret = new ArrayList<>();
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offerLast(root);
        while(!dq.isEmpty()){
            int curSize = dq.size();
            for(int i=0;i<curSize;i++){
                TreeNode curNode = dq.pollFirst();
                if(i==0){
                    // the most right tree node
                    ret.add(curNode.val);
                }    
                if(curNode.right!=null){
                    dq.offerLast(curNode.right);
                }
                if(curNode.left!=null){
                    dq.offerLast(curNode.left);
                }
            }
        }
        return ret;
    }
}
// @lc code=end

