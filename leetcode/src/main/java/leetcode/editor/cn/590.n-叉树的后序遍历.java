import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
 * @Author: dingrui
 * @Date: 2021-06-19 17:12:43
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-19 17:23:59
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N 叉树的后序遍历
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
    public List<Integer> postorder(Node root) {
        // 左-右-根 <= 根->右->左 反转
        List<Integer> res = new ArrayList<>();
        // base case
        if (root == null) {
            return res;
        }
        // 栈结构模拟递归栈
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            // stack top element
            Node node = stack.pop();
            // children left->right
            List<Node> children = node.children;
            // root value
            res.add(node.val);
            if (children != null && children.size() > 0) {
                // FILO
                for (int i = 0; i <= children.size() - 1; i++) {
                    stack.push(children.get(i));
                }
            }
        }
        // 根-右-左 => 左-右-根
        Collections.reverse(res);
        return res;
    }
}
// @lc code=end
