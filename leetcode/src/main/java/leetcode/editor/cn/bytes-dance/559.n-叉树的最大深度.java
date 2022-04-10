/*
 * @lc app=leetcode.cn id=559 lang=java
 *
 * [559] N 叉树的最大深度
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
    public int maxDepth(Node root) {
        if(root==null) return 0;
        return this.dfs(root, 1);
    }

    private int dfs(Node node, int level)
    {
        if(node==null) return 0;
        List<Node> children=node.children;
        if(children==null || children.size()==0) return level;
        int ret=0;
        for(Node child: children) ret=Math.max(ret,this.dfs(child, level+1));
        return ret;
    }
}
// @lc code=end

