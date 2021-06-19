import java.util.LinkedList;
import java.util.Stack;

import javax.xml.soap.Node;

/*
 * @Author: dingrui
 * @Date: 2021-06-19 16:46:56
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-19 17:10:16
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N 叉树的前序遍历
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
    public List<Integer> preorder(Node root) {
        // 栈数据结构模拟递归栈 root-左-右
        List<Integer> res = new ArrayList<>();
        // base case
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            // 栈顶元素
            Node node = stack.pop();
            // root
            res.add(node.val);
            // 先右后左进 先左后右出
            List<Node> children = node.children;
            if (children != null && children.size() > 0) {
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }
        return res;
    }
}
// @lc code=end
