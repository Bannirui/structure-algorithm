/*
 * @lc app=leetcode.cn id=430 lang=java
 *
 * [430] 扁平化多级双向链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node dummyNode = new Node(0, null, head, null);
        this.dfs(dummyNode, head);
        dummyNode.next.prev = null;
        return dummyNode.next;
    }

    // 深搜
    private Node dfs(Node prev, Node cur) {
        // base case
        if (cur == null) {
            return prev;
        }
        prev.next = cur;
        cur.prev = prev;
        // 模拟二叉树先序
        Node tmp = cur.next;
        Node child = this.dfs(cur, cur.child);
        cur.child = null;
        return this.dfs(child, tmp);
    }
}
// @lc code=end
