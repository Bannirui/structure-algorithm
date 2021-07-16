/*
 * @Author: dingrui
 * @Date: 2021-07-16 13:33:26
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-16 14:18:19
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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

    // 中序数组
    private int[] inorder;
    // 后序数组
    private int[] postorder;
    // 中序 key=val val=index
    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 没有重复元素
        this.inorder = inorder;
        this.postorder = postorder;
        // 中序遍历中的值与脚标映射
        for (int i = 0; i < inorder.length; i++) {
            this.indexMap.put(inorder[i], i);
        }
        return this.dfs(0, inorder.length - 1, 0, postorder.length - 1);
    }

    // 在中序遍历的数组中根据值找到对应的下标位置
    private int findInorderIndex(int val) {
        return this.indexMap.get(val);
    }

    // inStart 中序 起始下标
    // inEnd 中序 结束下标
    // postStart 后序 起始下标
    // postEnd 后序 结束下标
    private TreeNode dfs(int inStart, int inEnd, int postStart, int postEnd) {
        // base case
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        // 后序找到root节点
        int rootVal = this.postorder[postEnd];
        // root在中序的脚标位置
        int rootValIndex = this.findInorderIndex(rootVal);
        // 中序遍历中 左子树 = inorder[inStart...rootIndex-1] 长度L=(rootIndex-1)-inStart+1
        // 中序遍历中 右子树 = inorder[rootIndex+1...inEnd] 长度R=inEnd-(rootIndex+1)
        // 后序遍历中 左子树 = postorder[postStart, postStart+L]
        // 后序遍历中 右子树 = postorder[postStart+L+1+R, postEnd]
        TreeNode root = new TreeNode(rootVal);
        int L = (rootValIndex - 1) - inStart + 1;
        int R = inEnd - (rootValIndex + 1) + 1;
        root.left = dfs(inStart, rootValIndex - 1, postStart, postStart + L - 1);
        root.right = dfs(rootValIndex + 1, inEnd, postStart + L - 1 + 1, postStart + L - 1 + 1 + R - 1);
        return root;
    }
}
// @lc code=end
