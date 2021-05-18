package leetcode.editor.cn;

//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 383 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
        // TreeNode node7 = new TreeNode(7);
        // TreeNode node15 = new TreeNode(15);
        // TreeNode node20 = new TreeNode(20);
        // TreeNode node9 = new TreeNode(9);
        // TreeNode node3 = new TreeNode(3);

        // node20.setLeft(node15);
        // node20.setRight(node7);
        // node3.setLeft(node9);
        // node3.setRight(node20);

        // List<List<Integer>> lists = solution.levelOrderBottom(node3);

        // System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            // 自顶向下层序遍历 这边是通过list的add(index,element)来将每一层的中间结果都放在最列表最左边 越下层越左边 相当于自底向上遍历
            List<List<Integer>> res = new ArrayList<>();
            // 队列维护链表
            if (root == null) {
                return res;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                // 当前这层放到列表中
                List<Integer> currentLevel = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = queue.poll();
                    currentLevel.add(treeNode.val);
                    // 当前这层是否还有子树 队列先进先出 先看左子树 再看右子树
                    if (treeNode.left != null) {
                        // 左子树放到队列
                        queue.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        // 右子树放到队列
                        queue.offer(treeNode.right);
                    }
                }
                res.add(0, currentLevel);
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}