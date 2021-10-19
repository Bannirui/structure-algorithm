import javax.print.attribute.standard.PresentationDirection;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution
{
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        return this.dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart,
            int inorderEnd)
    {
        // base case
        if (preorderStart > preorderEnd || inorderStart > inorderEnd)
        {
            return null;
        }
        // 前序 root-左-右 中序 左-root-右
        int rootVal = preorder[preorderStart];
        // 构建TreeNode
        TreeNode root = new TreeNode(rootVal);
        // root节点在中序中脚标
        int rootIdxOfInorder = this.rootIndexOfInorder(inorder, inorderStart, inorderEnd, rootVal);
        // 左树 结束脚标-开始脚标
        int nodeCntOfLeftTree = rootIdxOfInorder - inorderStart;
        // 倒推前序的脚标
        int leftTreeStart = preorderStart + 1;
        int leftTreeEnd = preorderStart + nodeCntOfLeftTree;
        root.left = this.dfs(preorder, leftTreeStart, leftTreeEnd, inorder, inorderStart, rootIdxOfInorder - 1);
        root.right = this.dfs(preorder, leftTreeEnd + 1, preorderEnd, inorder, rootIdxOfInorder + 1, inorderEnd);
        return root;
    }

    private int rootIndexOfInorder(int[] inorder, int start, int end, int rootVal)
    {
        for (int i = start; i <= end; i++)
        {
            if (inorder[i] == rootVal)
            {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end
