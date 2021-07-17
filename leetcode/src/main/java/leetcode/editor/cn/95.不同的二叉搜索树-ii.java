import java.util.ArrayList;
import java.util.List;

import leetcode.editor.cn.InvertBinaryTree.TreeNode;

/*
 * @Author: dingrui
 * @Date: 2021-07-17 09:41:00
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-17 11:31:48
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
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

    public List<TreeNode> generateTrees(int n) {
        return traceBack(1, n);
    }

    // [start...end]能形成的完全二叉树
    private List<TreeNode> traceBack(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        // base case
        if (start > end) {
            res.add(null);
            return res;
        }
        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        // [start...end]选个做头节点
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = traceBack(start, i - 1);
            List<TreeNode> rights = traceBack(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode head = new TreeNode(i);
                    head.left = left;
                    head.right = right;
                    res.add(head);
                }
            }
        }
        return res;
    }
}
// @lc code=end
