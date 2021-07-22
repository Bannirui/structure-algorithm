import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-22 20:48:30
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-22 21:09:03
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return Collections.emptyList();
        }
        this.dfs(root, 0, targetSum, new ArrayList<>());
        return this.res;
    }

    private void dfs(TreeNode node, int sum, int target, List<Integer> path) {
        // base case
        if (node != null && node.left == null && node.right == null) {
            // 找到一条策略结果
            if (sum + node.val == target) {
                this.res.add(new ArrayList<Integer>(path) {
                    {
                        add(node.val);
                    }
                });
                return;
            }
            return;
        }
        if (node.left != null) {
            dfs(node.left, sum + node.val, target, new ArrayList<Integer>(path) {
                {
                    add(node.val);
                }
            });
        }
        if (node.right != null) {
            dfs(node.right, sum + node.val, target, new ArrayList<Integer>(path) {
                {
                    add(node.val);
                }
            });
        }
    }
}
// @lc code=end
