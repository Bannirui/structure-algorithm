import java.util.Queue;

import leetcode.editor.cn.BinaryTreeTilt.TreeNode;

/*
 * @Author: dingrui
 * @Date: 2021-07-14 13:34:15
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-14 13:41:33
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
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
    public List<Integer> rightSideView(TreeNode root) {
        // bfs
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        bfs(root, res);
        return res;
    }

    private void bfs(TreeNode node, List<Integer> res) {
        // 每一层的最后一个
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            // 当前层 节点数 最后一个收集起来
            int size = q.size();
            for (int i = 1; i <= size; i++) {
                TreeNode cur = q.poll();
                if (i == size) {
                    res.add(cur.val);
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
    }
}
// @lc code=end
