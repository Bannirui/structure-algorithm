package leetcode.editor.cn;

//给定一个二叉树，返回所有从根节点到叶子节点的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
// Related Topics 树 深度优先搜索
// 👍 474 👎 0

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
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
        public List<String> binaryTreePaths(TreeNode root) {
            ArrayList<String> paths = new ArrayList<>();
            String currentPath = "";
            getAllPaths(root, paths, "");
            return paths;
        }

        private void getAllPaths(TreeNode root, List<String> paths, String currentPath) {
            if (root != null) {
                StringBuffer sb = new StringBuffer(currentPath);
                sb.append(root.val);
                if (root.left == null && root.right == null) {
                    // 叶子节点
                    paths.add(sb.toString());
                } else {
                    sb.append("->");
                    getAllPaths(root.left, paths, sb.toString());
                    getAllPaths(root.right, paths, sb.toString());
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
