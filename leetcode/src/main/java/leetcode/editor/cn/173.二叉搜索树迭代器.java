/*
 * @Author: dingrui
 * @Date: 2021-07-29 11:20:07
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-29 11:32:10
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=173 lang=java
 *
 * [173] 二叉搜索树迭代器
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
class BSTIterator {

    private List<Integer> list = new ArrayList<>();

    private int curIndex = 0;

    public BSTIterator(TreeNode root) {
        // 中序遍历
        this.inOrder(root);
    }

    public int next() {
        return this.list.get(curIndex++);
    }

    public boolean hasNext() {
        return curIndex < this.list.size();
    }

    private void inOrder(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end
