import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        // 先取最左节点
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                // 左子节点
                root = root.left;
            }
            // 开始取
            root = stack.pop();
            // 消费了一个最小元素
            k--;
            if (k == 0) {
                // root就是要找的第k个最小的元素
                break;
            }
            // 当前子树的右节点情况
            root = root.right;
        }
        return root.val;
    }
}
// @lc code=end
