import java.util.Deque;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution
{
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> res = new ArrayList<>();
        // base case
        if (root == null)
        {
            return res;
        }
        // 队列
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offerLast(root);
        while (!dq.isEmpty())
        {
            // 当前层的节点数量
            int size = dq.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++)
            {
                TreeNode cur = dq.pollFirst();
                level.add(cur.val);
                if (cur.left != null)
                {
                    dq.offerLast(cur.left);
                }
                if (cur.right != null)
                {
                    dq.offerLast(cur.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
// @lc code=end
