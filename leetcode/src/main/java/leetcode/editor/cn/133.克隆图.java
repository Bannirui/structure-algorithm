import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.soap.Node;

/*
 * @Author: dingrui
 * @Date: 2021-07-26 11:09:21
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-27 16:58:51
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=133 lang=java
 *
 * [133] 克隆图
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        // dfs
        // base case
        if (node == null) {
            return null;
        }
        // 克隆当前节点
        if (this.visited.containsKey(node)) {
            return this.visited.get(node);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        this.visited.put(node, clone);
        // 邻居
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return clone;
    }
}
// @lc code=end
