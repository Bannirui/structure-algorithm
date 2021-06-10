package leetcode.editor.cn;

//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征：
//
//
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
// 示例 1:
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
//
//
// 示例 2:
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
//
// Related Topics 树 深度优先搜索 递归
// 👍 1089 👎 0

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

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
    class IsValidBSTInfo {
        // 是否是有效BST
        boolean isBST;
        // 最大值
        int max;
        // 最小值
        int min;

        public IsValidBSTInfo(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }

        public boolean isBST() {
            return isBST;
        }

        public void setBST(boolean BST) {
            isBST = BST;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return getInfo(root).isBST;
        }

        public IsValidBSTInfo getInfo(TreeNode x) {
            // base case
            if (x == null) {
                return null;
            }
            // 左子树
            IsValidBSTInfo L = getInfo(x.left);
            // 右子树
            IsValidBSTInfo R = getInfo(x.right);
            // 自己的
            boolean isBST = false;
            int max = x.val;
            int min = x.val;

            if (
                    (L != null ? L.isBST : true) &&
                            (L != null ? L.max < x.val : true) &&
                            (R != null ? R.isBST : true) &&
                            (R != null ? x.val < R.min : true)

            ) {
                isBST = true;
            }
            max = Math.max(Math.max((L != null ? L.max : x.val), (R != null ? R.max : x.val)),
                    max);
            min = Math.min(Math.min((L != null ? L.min : x.val), (R != null ? R.min : x.val)),
                    min);
            return new IsValidBSTInfo(isBST, max, min);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
