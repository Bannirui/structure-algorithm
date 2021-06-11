package leetcode.editor.cn;

//如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
//
// 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
//
//
//
// 示例 1：
//
//
//
// 输入：[1,1,1,1,1,null,1]
//输出：true
//
//
// 示例 2：
//
//
//
// 输入：[2,2,2,5,2]
//输出：false
//
//
//
//
// 提示：
//
//
// 给定树的节点数范围是 [1, 100]。
// 每个节点的值都是整数，范围为 [0, 99] 。
//
// Related Topics 树
// 👍 83 👎 0

public class UnivaluedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new UnivaluedBinaryTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    class IsUnivalTreeInfo {
        // 树是否是单值二叉树
        boolean isUnival;
        // 树根节点值
        int rootVal;

        public IsUnivalTreeInfo(boolean isUnival, int rootVal) {
            this.isUnival = isUnival;
            this.rootVal = rootVal;
        }
    }

    class Solution {
        public boolean isUnivalTree(TreeNode root) {
            return getInfo(root).isUnival;
        }

        public IsUnivalTreeInfo getInfo(TreeNode x) {
            // base case
            if (x == null) {
                return null;
            }
            // 子树
            IsUnivalTreeInfo left = getInfo(x.left);
            IsUnivalTreeInfo right = getInfo(x.right);
            // 整合
            boolean isUnival = false;
            if (
                // 左树单值
                    (left != null ? left.isUnival : true) &&
                            // 右树单值
                            (right != null ? right.isUnival : true) &&
                            // 自己也是单值
                            (left == null ?
                                    (right == null ? true : (right.rootVal == x.val)) :
                                    (right == null ?
                                            (left.rootVal == x.val) :
                                            ((left.rootVal == x.val) && (right.rootVal == x.val))))
            ) {
                isUnival = true;
            }
            int rootVal = x.val;
            return new IsUnivalTreeInfo(isUnival, rootVal);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
