package leetcode.editor.cn;

//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 递归 
// 👍 767 👎 0

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

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
        public int maxDepth(TreeNode root) {
            // 根节点为空
            if (root == null) {
                return 0;
            }
            // 只有根节点 没有子节点
            if (root.left == null && root.right == null) {
                return 1;
            }
            // 有子节点 深度为左右子节点中的最大值
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}