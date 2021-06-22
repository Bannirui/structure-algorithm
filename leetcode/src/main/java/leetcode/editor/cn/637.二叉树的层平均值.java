import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.editor.cn.BinaryTreeTilt.TreeNode;

/*
 * @Author: dingrui
 * @Date: 2021-06-22 11:31:00
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-22 13:35:49
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=637 lang=java
 *
 * [637] 二叉树的层平均值
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
    public List<Double> averageOfLevels(TreeNode root) {
        // bfs
        // return bfs(root);

        // dfs
        List<Double> sums = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        List<Double> res = new ArrayList<>();
        dfs(root, 0, sums, counts);
        for (int i = 0; i < sums.size(); i++) {
            res.add(sums.get(i) / counts.get(i));
        }
        return res;
    }

    public void dfs(TreeNode root, int curLevel, List<Double> sums, List<Integer> counts) {
        // base case
        if (root == null) {
            return;
        }
        // root
        // 当前层curLevel已经记录过 没记录过
        if (curLevel < sums.size()) {
            // 记录过 累加
            sums.set(curLevel, sums.get(curLevel) + root.val);
            counts.set(curLevel, counts.get(curLevel) + 1);
        } else {
            // 没记录过
            sums.add((double) root.val);
            counts.add(1);
        }
        dfs(root.left, curLevel + 1, sums, counts);
        dfs(root.right, curLevel + 1, sums, counts);
    }

    public List<Double> bfs(TreeNode root) {
        List<Double> res = new ArrayList<>();
        // base case
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            // val counts for cur level
            int counts = q.size();
            // val sum for cur level
            double sum = 0;
            for (int i = 0; i < counts; i++) {
                TreeNode curNode = q.poll();
                sum += curNode.val;
                if (curNode.left != null) {
                    q.add(curNode.left);
                }
                if (curNode.right != null) {
                    q.add(curNode.right);
                }
            }
            res.add(sum / counts);
        }
        return res;
    }
}
// @lc code=end
