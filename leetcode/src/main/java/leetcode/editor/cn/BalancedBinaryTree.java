package leetcode.editor.cn;

//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为：
//
//
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
//
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
//
//
// 示例 3：
//
//
//输入：root = []
//输出：true
//
//
//
//
// 提示：
//
//
// 树中的节点数在范围 [0, 5000] 内
// -104 <= Node.val <= 104
//
// Related Topics 树 深度优先搜索 递归
// 👍 701 👎 0

import java.util.regex.Matcher;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
//Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class BalanceTreeNodeInfo {

        // 是否是完全二叉树
        boolean isAllBalanced;

        // 树高
        int height;

        public BalanceTreeNodeInfo(boolean isAllBalanced, int height) {
            this.isAllBalanced = isAllBalanced;
            this.height = height;
        }

        public boolean isAllBalanced() {
            return isAllBalanced;
        }

        public void setAllBalanced(boolean allBalanced) {
            isAllBalanced = allBalanced;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    class Solution {
        public boolean isBalanced(TreeNode root) {
            return obtainInfo(root).isAllBalanced();
        }

        public BalanceTreeNodeInfo obtainInfo(TreeNode x) {
            // base case
            if (x == null) {
                return new BalanceTreeNodeInfo(true, 0);
            }
            // 左右节点信息
            BalanceTreeNodeInfo leftTreeInfo = obtainInfo(x.left);
            BalanceTreeNodeInfo rightTreeInfo = obtainInfo(x.right);
            // 整合自己信息
            boolean isBalanced = true;
            int height = Math.max(leftTreeInfo.getHeight(), rightTreeInfo.getHeight()) + 1;
            if (
                    !leftTreeInfo.isAllBalanced() ||
                            !rightTreeInfo.isAllBalanced() ||
                            Math.abs(leftTreeInfo.getHeight() - rightTreeInfo.getHeight()) > 1
            ) {
                isBalanced = false;
            }
            return new BalanceTreeNodeInfo(isBalanced, height);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
