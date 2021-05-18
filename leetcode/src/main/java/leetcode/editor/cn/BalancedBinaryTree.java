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
// 👍 555 👎 0

public class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();

        // TreeNode node1 = new TreeNode(1);
        // TreeNode node2 = new TreeNode(2);
        // TreeNode node3 = new TreeNode(2);
        // TreeNode node4 = new TreeNode(3);
        // TreeNode node5 = new TreeNode(3);
        // TreeNode node6 = new TreeNode(4);
        // TreeNode node7 = new TreeNode(4);

        // node4.left=node6;
        // node4.right=node7;
        // node2.left=node4;
        // node2.right=node5;
        // node1.left=node2;
        // node1.right=node3;

        // boolean balanced = solution.isBalanced(node1);
        // System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    // Definition for a binary tree node.
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

    class Solution {
        public boolean isBalanced(TreeNode root) {
            // return Math.abs(treeHeight(root, true) - treeHeight(root, false)) <= 1;
            if (root == null) {
                return true;
            }
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        public int height(TreeNode root) {
            // 根节点为空
            if (root == null) {
                return 0;
            }
            // 根节点不为空
            return Math.max(height(root.left), height(root.right)) + 1;
        }

        public int treeHeight(TreeNode root, boolean isLongest) {
            if (isLongest) {
                // 最长路径
                // 根节点为空
                if (root == null) {
                    return 0;
                }
                // 根节点不为空 左右子节点都为空
                if (root.left == null && root.right == null) {
                    return 1;
                }
                // 根节点不为空 左右子节点可能为空
                if (root.left == null) {
                    return treeHeight(root.right, isLongest) + 1;
                }
                if (root.right == null) {
                    return treeHeight(root.left, isLongest) + 1;
                }
                // 根节点不为空 左右子节点都不为空
                return Math.max(treeHeight(root.left, isLongest), treeHeight(root.right, isLongest)) + 1;
            } else {
                // 最短路径
                // 根节点为空
                if (root == null) {
                    return 0;
                }
                // 根节点不为空 左右子节点只要有一个为空 最短路径都是当前节点1
                if (root.left == null || root.right == null) {
                    return 1;
                }
                // 根节点不为空 左右子节点都不为空
                return Math.min(treeHeight(root.left, isLongest), treeHeight(root.right, isLongest)) + 1;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}