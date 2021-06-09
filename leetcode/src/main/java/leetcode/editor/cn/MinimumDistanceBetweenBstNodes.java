package leetcode.editor.cn;

//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
//
// 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bs
//t/ 相同
//
//
//
//
//
// 示例 1：
//
//
//输入：root = [4,2,6,1,3]
//输出：1
//
//
// 示例 2：
//
//
//输入：root = [1,0,48,null,null,12,49]
//输出：1
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [2, 100] 内
// 0 <= Node.val <= 105
// 差值是一个正数，其数值等于两值之差的绝对值
//
//
//
// Related Topics 树 深度优先搜索 递归
// 👍 193 👎 0

public class MinimumDistanceBetweenBstNodes {
    public static void main(String[] args) {
        Solution solution = new MinimumDistanceBetweenBstNodes().new Solution();
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
    class Solution {
        public int minDiffInBST(TreeNode root) {
            return getInfo(root).minDiff;
        }

        // 递归获取树信息
        public MinDiffBSTInfo getInfo(TreeNode x) {
            // base case 后面接到返回值就需要对null进行单独判断了
            if (x == null) {
                return null;
            }
            // 子树信息 返回值可能为null
            MinDiffBSTInfo leftInfo = getInfo(x.left);
            MinDiffBSTInfo rightInfo = getInfo(x.right);
            // 整合成自己的信息
            int minDiff = Integer.MAX_VALUE;
            int rootValue = x.val;
            int minValue = x.val;
            int maxValue = x.val;
            // 子树的最小值跟子树root节点差值比较
            if (leftInfo == null) {
                if (rightInfo == null) {
                    // 叶子节点
                } else {
                    // 只有右节点
                    minDiff = Math.min(
                            Math.min(minDiff,
                                    rightInfo.getMinDiff()),
                            rightInfo.minValue - x.val
                    );
                    // 关注右树上的最大值
                    maxValue = rightInfo.maxValue;
                }
            } else {
                if (rightInfo == null) {
                    // 只有左节点
                    minDiff = Math.min(Math.min(minDiff,
                            leftInfo.getMinDiff()),
                            x.val - leftInfo.maxValue);
                    minValue = leftInfo.minValue;
                } else {
                    // 有两个节点
                    minDiff = Math.min(Math.min(minDiff,
                            leftInfo.getMinDiff()),
                            rightInfo.getMinDiff());
                    // 二叉搜索树的特点 左右树极值比较
                    int diff = Math.min(x.val - leftInfo.maxValue, rightInfo.minValue - x.val);
                    minDiff = Math.min(minDiff, diff);
                    minValue = leftInfo.minValue;
                    maxValue = rightInfo.maxValue;
                }
            }
            return new MinDiffBSTInfo(minDiff, maxValue, minValue, rootValue);
        }
    }

    // 树的信息
    class MinDiffBSTInfo {

        // 树的任意两个节点的最小差值
        int minDiff;
        // 树上的最大值最小值
        int maxValue;
        int minValue;
        // 树当前跟节点的值
        int rootValue;

        public MinDiffBSTInfo(int minDiff, int maxValue, int minValue, int rootValue) {
            this.minDiff = minDiff;
            this.maxValue = maxValue;
            this.minValue = minValue;
            this.rootValue = rootValue;
        }

        public int getMinDiff() {
            return minDiff;
        }

        public void setMinDiff(int minDiff) {
            this.minDiff = minDiff;
        }

        public int getMaxValue() {
            return maxValue;
        }

        public void setMaxValue(int maxValue) {
            this.maxValue = maxValue;
        }

        public int getMinValue() {
            return minValue;
        }

        public void setMinValue(int minValue) {
            this.minValue = minValue;
        }

        public int getRootValue() {
            return rootValue;
        }

        public void setRootValue(int rootValue) {
            this.rootValue = rootValue;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
