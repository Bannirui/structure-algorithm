import java.util.Arrays;

/*
 * @Author: dingrui
 * @Date: 2021-06-22 16:02:46
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-22 17:25:20
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=671 lang=java
 *
 * [671] 二叉树中第二小的节点
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
    public int findSecondMinimumValue(TreeNode root) {
        // dfs
        FindSecondMinimumValueInfo info = dfs(root);
        // 最小和第二小的值一样
        return (info.firMin == info.secMin) ? -1 : info.secMin;
    }

    class FindSecondMinimumValueInfo {
        // 最小值
        int firMin;
        // 第二小值
        int secMin;

        public FindSecondMinimumValueInfo() {
        }

        public FindSecondMinimumValueInfo(int firMin, int secMin) {
            this.firMin = firMin;
            this.secMin = secMin;
        }
    }

    public FindSecondMinimumValueInfo dfs(TreeNode X) {
        // 要么没有子树 要么同时有左右子树
        // base case
        if (X == null) {
            return null;
        }
        // 子树信息
        FindSecondMinimumValueInfo left = dfs(X.left);
        FindSecondMinimumValueInfo right = dfs(X.right);
        // 整合信息
        FindSecondMinimumValueInfo info = new FindSecondMinimumValueInfo();
        if (left != null && right != null) {
            // 此时的root就是当前树的最小值
            info.firMin = X.val;
            int tmpSecMin = X.val;
            // 子树中4个值找第二小的值 遍历4个值
            int[] tmpArr = new int[4];
            tmpArr[0] = left.firMin;
            tmpArr[1] = left.secMin;
            tmpArr[2] = right.firMin;
            tmpArr[3] = right.secMin;
            Arrays.sort(tmpArr);
            for (int i = 0; i < 4; i++) {
                if (tmpArr[i] > tmpSecMin) {
                    tmpSecMin = tmpArr[i];
                    break;
                }
            }
            info.secMin = tmpSecMin;
        }
        if (left == null && right == null) {
            info.firMin = X.val;
            info.secMin = X.val;
        }
        return info;
    }
}
// @lc code=end
