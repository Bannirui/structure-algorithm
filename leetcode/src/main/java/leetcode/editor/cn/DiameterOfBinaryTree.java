package leetcode.editor.cn;

//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
//
//
//
// 示例 :
//给定二叉树
//
//           1
//         / \
//        2   3
//       / \
//      4   5
//
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
//
//
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。
// Related Topics 树
// 👍 716 👎 0

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
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

    class DiameterOfBinaryTreeInfo {
        // 最大长度
        int maxLen;
        // 高度
        int height;

        public DiameterOfBinaryTreeInfo(int maxLen, int height) {
            this.maxLen = maxLen;
            this.height = height;
        }

        public int getMaxLen() {
            return maxLen;
        }

        public void setMaxLen(int maxLen) {
            this.maxLen = maxLen;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    class Solution {
        public int diameterOfBinaryTree(TreeNode root) {
            /**
             * 不穿过x节点 --> pk子树最大长度
             *     左树最大长度
             *     右树最大长度
             * 穿过x节点 --> 子树高度之和+1
             *     左树高度
             *     右树高度
             *
             * 信息汇总：
             * 最大长度
             * 高度
             */
            // 计算出来的maxLen是最大路径上节点的数量 题目中要求的是边的数量
            return getInfo(root).getMaxLen()-1;
        }

        public DiameterOfBinaryTreeInfo getInfo(TreeNode x) {
            // base case
            if (x == null) {
                return new DiameterOfBinaryTreeInfo(0, 0);
            }
            // 子树信息
            DiameterOfBinaryTreeInfo leftInfo = getInfo(x.left);
            DiameterOfBinaryTreeInfo rightInfo = getInfo(x.right);
            // 整合
            int maxLen = Math.max(Math.max(leftInfo.getMaxLen(),
                    rightInfo.getMaxLen()),
                    leftInfo.getHeight() + rightInfo.getHeight() + 1);
            int height = Math.max(leftInfo.getHeight(), rightInfo.getHeight()) + 1;
            return new DiameterOfBinaryTreeInfo(maxLen, height);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
