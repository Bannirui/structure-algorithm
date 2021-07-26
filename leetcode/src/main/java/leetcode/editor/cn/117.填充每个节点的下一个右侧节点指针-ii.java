/*
 * @Author: dingrui
 * @Date: 2021-07-23 16:11:46
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-26 08:20:32
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            // 当前层节点个数
            int size = q.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                if (i != 0) {
                    pre.next = cur;
                }
                pre = cur;
            }
        }
        return root;
    }
}
// @lc code=end
