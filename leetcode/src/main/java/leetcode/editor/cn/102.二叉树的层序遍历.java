import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.editor.cn.InvertBinaryTree.TreeNode;

/*
 * @Author: dingrui
 * @Date: 2021-07-14 13:18:18
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-14 13:30:26
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // bfs
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        bfs(root, res);
        return res;
    }

    private void bfs(TreeNode node, List<List<Integer>> res) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            // 消费size个元素
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();
            while (size != 0) {
                TreeNode cur = q.poll();
                tmp.add(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                size--;
            }
            res.add(tmp);
        }
    }
}
// @lc code=end
