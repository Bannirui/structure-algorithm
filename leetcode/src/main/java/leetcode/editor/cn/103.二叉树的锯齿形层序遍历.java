import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.editor.cn.BinaryTreeTilt.TreeNode;

/*
 * @Author: dingrui
 * @Date: 2021-07-16 15:32:19
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-16 15:57:31
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    // 初始化遍历方向为 左->右
    private boolean left2Right = true;
    // 结果集
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 宽度优先 标志位取反
        if (root == null) {
            return this.res;
        }
        this.bfs(root);
        return this.res;
    }

    private void bfs(TreeNode node) {
        Deque<TreeNode> q = new LinkedList<>();
        // 放的时候 先放左 再放右
        q.offerLast(node);
        while (!q.isEmpty()) {
            // 消费 数量 方向
            int size = q.size();
            List<Integer> path = new ArrayList<>();
            while (size != 0) {
                TreeNode cur = null;
                if (this.left2Right) {
                    // 消费的时候 根据标志位
                    cur = q.pollFirst();
                } else {
                    cur = q.pollLast();
                }
                path.add(cur.val);
                // 存的时候调整顺序
                if (this.left2Right) {
                    if (cur.left != null) {
                        q.offerLast(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                } else {
                    if (cur.right != null) {
                        q.offerFirst(cur.right);
                    }
                    if (cur.left != null) {
                        q.offerFirst(cur.left);
                    }
                }
                size--;
            }
            // 收集结果
            this.res.add(path);
            // 调整下一次消费方向标志
            if (size == 0) {
                this.left2Right = !this.left2Right;
            }
        }
    }
}
// @lc code=end
