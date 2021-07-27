/*
 * @Author: dingrui
 * @Date: 2021-07-26 07:28:42
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-27 09:24:13
 * @Descripttion: 
 */
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
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        // 逐层
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                // 子树
                if (cur.children != null && !cur.children.isEmpty()) {
                    for (Node child : cur.children) {
                        // 从左到右添加
                        q.offer(child);
                    }
                }
                // 消费当前节点
                level.add(cur.val);
            }
            res.add(level);
        }
        return res;
    }
}
// @lc code=end
