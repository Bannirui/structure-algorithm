package leetcode.editor.cn;

//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1185 👎 0

public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return dfs(root.left, root.right);
        }

        public boolean dfs(TreeNode left, TreeNode right) {
            // 左右都为空 对称
            if (left == null && right == null) {
                return true;
            }
            // 左右只有一个为空 不对称
            if (left == null | right == null) {
                return false;
            }
            // 左右都不为空 但是当前节点的值不相等
            if (left.val != right.val) {
                return false;
            }
            // 左右都不为空 当前节点值相等
            return dfs(left.left, right.right) && dfs(left.right, right.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}