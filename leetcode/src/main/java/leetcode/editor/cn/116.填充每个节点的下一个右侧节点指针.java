import java.util.Deque;
import java.util.LinkedList;

import javax.xml.soap.Node;

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

class Solution
{
    public Node connect(Node root)
    {
        // 层序遍历 把每层的节点链表挂起来
        return this.bfs(root);
    }

    private Node bfs(Node root)
    {
        // base case
        if (root == null)
        {
            return root;
        }
        Deque<Node> dq = new LinkedList<>();
        // 根节点入队列
        dq.offerLast(root);
        while (!dq.isEmpty())
        {
            // 层级上节点数量
            int levelSize = dq.size();
            // 遍历层级上的节点
            for (int i = 0; i < levelSize; i++)
            {
                // 如果当前节点是层上的最后一个节点 指向null
                Node cur = dq.pollFirst();
                if (i < levelSize - 1)
                {
                    cur.next = dq.peekFirst();
                }
                // 加入子节点
                if (cur.left != null)
                {
                    dq.offerLast(cur.left);
                }
                if (cur.right != null)
                {
                    dq.offerLast(cur.right);
                }
            }
        }
        return root;
    }
}
// @lc code=end
