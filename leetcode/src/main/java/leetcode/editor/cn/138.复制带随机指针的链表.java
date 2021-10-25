import javax.xml.soap.Node;

/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // base case
        if (head == null) {
            return null;
        }
        // a->b->c
        // a->a'->b->b'->c->c'
        // a'->b'->c'
        for (Node cur = head; cur != null; cur = cur.next.next) {
            // 创建copy节点
            Node cpNode = new Node(cur.val);
            // 挂到原链表中
            cpNode.next = cur.next;
            cur.next = cpNode;
        }
        // random指针
        for (Node cur = head; cur != null; cur = cur.next.next) {
            // 通过next指针获取copy节点
            Node cpNode = cur.next;
            // 原节点的random
            Node preRandom = cur.random;
            // 复制节点的random一定是原节点的复制节点
            Node cpRandom = null;
            if (preRandom == null) {
                cpRandom = null;
            } else {
                cpRandom = preRandom.next;
            }
            cpNode.random = cpRandom;
        }
        // 复制节点单独抽出来
        Node cpHead = head.next;
        for (Node cur = head; cur != null; cur = cur.next) {
            Node cpNode = cur.next;
            cur.next = cpNode.next;
            cpNode.next = cpNode.next == null ? null : cpNode.next.next;
        }
        return cpHead;
    }
}
// @lc code=end
