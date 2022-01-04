/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N 叉树的层序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root==null) return ret; // base case
        Queue<Node> q = new LinkedList<>(); // record the node of tree from left to right by level
        q.offer(root);
        while(!q.isEmpty()){ // iterator until the q is empty
            int size = q.size(); // cnt for cur level
            List<Integer> levelRet = new ArrayList<>();
            for(int i=0; i<size; i++){
                Node curNode = q.poll(); // iterator node for each lebel
                levelRet.add(curNode.val);
                if(curNode.children!=null && !curNode.children.isEmpty()){
                    for(Node child: curNode.children){
                        q.offer(child);
                    }
                }
            }
            ret.add(levelRet);
        }
        return ret;
    }
}
// @lc code=end

