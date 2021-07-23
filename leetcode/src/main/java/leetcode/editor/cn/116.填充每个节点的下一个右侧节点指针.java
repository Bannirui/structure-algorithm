/*
 * @Author: dingrui
 * @Date: 2021-07-23 15:56:20
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-23 16:10:34
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
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
        // bfs
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            // 一层的节点
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (i != size - 1) {
                    // 不是这一层的最右边的节点 都需要调整next指针
                    cur.next = q.peek();
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
        return root;
    }
}
// @lc code=end
