import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.standard.PresentationDirection;

/*
 * @Author: dingrui
 * @Date: 2021-07-16 15:08:21
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-16 15:30:03
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    // 前序 root-左-右
    private int[] preorder;
    // 中序 左-root-右
    private int[] inorder;
    // 中序中脚标映射关系 key=val value=index
    Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 递归
        // 前序数组
        this.preorder = preorder;
        // 中序数组
        this.inorder = inorder;
        // 中序脚标
        for (int i = 0; i < inorder.length; i++) {
            this.inorderIndexMap.put(inorder[i], i);
        }
        return this.dfs(0, preorder.length - 1, 0, inorder.length - 1);
    }

    // 找到中序遍历中值对应的脚标
    private int findInorderIndex(int val) {
        return this.inorderIndexMap.get(val);
    }

    // preStart 前序开始脚标
    // preEnd 前序结束脚标
    // inStart 中序开始脚标
    // inEnd 中序结束脚标
    private TreeNode dfs(int preStart, int preEnd, int inStart, int inEnd) {
        // base case
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // root节点就是前序的第一个节点
        int root = this.preorder[preStart];
        // root在中序中的脚标
        int inorderRootIndex = this.findInorderIndex(root);
        // 中序中两个子树的脚标差
        int leftGap = inorderRootIndex - inStart;
        int rightGap = inEnd - inorderRootIndex;
        TreeNode rootNode = new TreeNode(root);
        rootNode.left = dfs(preStart + 1, preStart + 1 + leftGap - 1, inStart, inStart + leftGap - 1);
        rootNode.right = dfs(preEnd - rightGap + 1, preEnd, inEnd - rightGap + 1, inEnd);
        return rootNode;
    }
}
// @lc code=end
