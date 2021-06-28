import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-06-28 17:44:49
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-28 18:03:56
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=872 lang=java
 *
 * [872] 叶子相似的树
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        return list1.equals(list2);
    }

    // 先序遍历
    private void dfs(TreeNode root, List<Integer> list) {
        // base case
        if (root == null) {
            return;
        }
        if (isLeaf(root)) {
            list.add(root.val);
        }
        dfs(root.left, list);
        dfs(root.right, list);
    }

    // 是否是叶子节点
    private boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }

}
// @lc code=end
