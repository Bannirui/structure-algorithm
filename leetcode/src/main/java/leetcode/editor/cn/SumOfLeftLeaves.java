// package leetcode.editor.cn;
//
// //计算给定二叉树的所有左叶子之和。
// //
// // 示例：
// //
// //
// //    3
// //   / \
// //  9  20
// //    /  \
// //   15   7
// //
// //在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
// //
// //
// // Related Topics 树
// // 👍 302 👎 0
//
// import java.util.LinkedList;
// import java.util.Queue;
//
// public class SumOfLeftLeaves {
//     public static void main(String[] args) {
//         Solution solution = new SumOfLeftLeaves().new Solution();
//     }
//
//     //leetcode submit region begin(Prohibit modification and deletion)
//
//     /**
//      * Definition for a binary tree node.
//      * public class TreeNode {
//      *     int val;
//      *     TreeNode left;
//      *     TreeNode right;
//      *     TreeNode() {}
//      *     TreeNode(int val) { this.val = val; }
//      *     TreeNode(int val, TreeNode left, TreeNode right) {
//      *         this.val = val;
//      *         this.left = left;
//      *         this.right = right;
//      *     }
//      * }
//      */
//     class Solution {
//         public int sumOfLeftLeaves(TreeNode root) {
//             // 左子叶 深度优先 广度优先
//             int sum = 0;
//             if (root == null) {
//                 return sum;
//             }
//             // return dfs(root);
//             return bfs(root);
//         }
//
//         private int dfs(TreeNode root) {
//             int sum = 0;
//             if (root.left != null) {
//                 if (isLeaf(root.left)) {
//                     // 左子节点是叶子节点
//                     sum += root.left.val;
//                 } else {
//                     // 左子节点不是叶子节点
//                     sum += dfs(root.left);
//                 }
//             }
//             if (root.right != null) {
//                 if (isLeaf(root.right)) {
//                     // 右子节点是叶子节点 pass
//                 } else {
//                     // 右子节点不是叶子节点 递归
//                     sum += dfs(root.right);
//                 }
//             }
//             return sum;
//         }
//
//         private int bfs(TreeNode root) {
//             int sum = 0;
//             Queue<TreeNode> queue = new LinkedList<TreeNode>();
//             queue.offer(root);
//             while (!queue.isEmpty()) {
//                 TreeNode node = queue.poll();
//                 if (node.left != null) {
//                     if (isLeaf(node.left)) {
//                         // 左子节点是叶子节点
//                         sum += node.left.val;
//                     } else {
//                         // 左子节点不是叶子节点
//                         queue.offer(node.left);
//                     }
//                 }
//                 if (node.right != null) {
//                     if (isLeaf(node.right)) {
//                         // 右子节点是叶子节点
//                     } else {
//                         // 右子节点不是叶子节点
//                         queue.offer(node.right);
//                     }
//                 }
//             }
//             return sum;
//         }
//
//         private boolean isLeaf(TreeNode node) {
//             return node != null && node.left == null && node.right == null;
//         }
//     }
// //leetcode submit region end(Prohibit modification and deletion)
//
// }
