package leetcode.editor.cn;

//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
//
//
//
// 示例：
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
//
//
//
//
// 提示：
//
//
// 树中至少有 2 个节点。
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
//相同
//
// Related Topics 树
// 👍 256 👎 0

import org.omg.CORBA.RepositoryIdHelper;

import javax.management.MBeanServerInvocationHandler;

public class MinimumAbsoluteDifferenceInBst {
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifferenceInBst().new Solution();
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

    class MinDiffInfo {
        // 子树差值绝对值最小值
        int minAbsDiff;
        // 子树最大值
        int maxVal;
        // 子树最小值
        int minVal;

        public MinDiffInfo(int minAbsDiff, int maxVal, int minVal) {
            this.minAbsDiff = minAbsDiff;
            this.maxVal = maxVal;
            this.minVal = minVal;
        }
    }

    class Solution {
        public int getMinimumDifference(TreeNode root) {
            return getInfo(root).minAbsDiff;
        }

        public MinDiffInfo getInfo(TreeNode x) {
            // base case
            if (x == null) {
                return null;
            }
            // 子树
            MinDiffInfo left = getInfo(x.left);
            MinDiffInfo right = getInfo(x.right);
            // 自己
            int minAbsDiff = Integer.MAX_VALUE;
            int maxVal = x.val;
            int minVal = x.val;
            if (left == null) {
                if (right == null) {
                    // root节点 没有子树
                } else {
                    // 只有右子树
                    minAbsDiff = Math.min(
                            // 右子树最小差值
                            right.minAbsDiff,
                            Math.min(
                                    // 右子树最小值跟根节点差值
                                    Math.abs(right.minVal - x.val),
                                    // 右子树最大值跟根节点差值
                                    Math.abs(right.maxVal - x.val)
                            )
                    );
                    maxVal = right.maxVal;
                }
            } else {
                if (right == null) {
                    // 只有左子树
                    minAbsDiff = Math.min(
                            // 左子树最小差值
                            left.minAbsDiff,
                            Math.min(
                                    // 左子树最大值跟根节点差值
                                    Math.abs(x.val - left.maxVal),
                                    // 左子树最小值跟根节点差值
                                    Math.abs(x.val - left.minVal)
                            )
                    );
                    minVal = left.minVal;
                } else {
                    // 同时有左右子树
                    minAbsDiff = Math.min(
                            // 左子树 右子树 最小差值
                            Math.min(left.minAbsDiff, right.minAbsDiff),

                            Math.min(
                                    // 左子树
                                    Math.min(Math.abs(left.maxVal - x.val), Math.abs(left.minVal - x.val)),
                                    // 右子树
                                    Math.min(Math.abs(right.maxVal - x.val), Math.abs(right.minVal - x.val))
                            )
                    );
                    maxVal = Math.max(
                            Math.max(left.maxVal, right.maxVal),
                            maxVal
                    );
                    minVal = Math.min(
                            Math.min(left.minVal, right.minVal),
                            minVal
                    );
                }
            }
            return new MinDiffInfo(minAbsDiff, maxVal, minVal);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
