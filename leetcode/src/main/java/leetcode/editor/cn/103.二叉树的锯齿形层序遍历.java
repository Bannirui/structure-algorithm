import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        List<List<Integer>> res = new ArrayList<>();
        // base case
        if (root == null)
        {
            return res;
        }
        Deque<TreeNode> dq = new LinkedList<>();
        // 每层取节点顺序 左->右
        boolean getFromL2R = true;
        dq.offerLast(root);
        while (!dq.isEmpty())
        {
            int levelSize = dq.size();
            Deque<Integer> levelRes = new LinkedList<>();
            for (int i = 0; i < levelSize; i++)
            {
                TreeNode cur = dq.pollFirst();
                if (getFromL2R)
                {
                    levelRes.offerLast(cur.val);
                }
                else
                {
                    levelRes.offerFirst(cur.val);
                }
                // 放: 左->右 取: 右->左
                if (cur.left != null)
                {
                    dq.offerLast(cur.left);
                }
                if (cur.right != null)
                {
                    dq.offerLast(cur.right);
                }
            }
            getFromL2R = !getFromL2R;
            res.add(new ArrayList<>(levelRes));
        }
        return res;
    }
}
// @lc code=end
