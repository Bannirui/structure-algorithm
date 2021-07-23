/*
 * @Author: dingrui
 * @Date: 2021-07-23 11:23:22
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-23 15:54:51
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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

    public void flatten(TreeNode root) {
        // 暴力版本 空间复杂度O(N)
        // 先序遍历的节点
        List<TreeNode> list = new ArrayList<>();
        this.preOrder(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    // 先序遍历 存储节点
    private void preOrder(TreeNode head, List<TreeNode> list) {
        // base case
        if (head == null) {
            return;
        }
        list.add(head);
        preOrder(head.left, list);
        preOrder(head.right, list);
    }
}
// @lc code=end
