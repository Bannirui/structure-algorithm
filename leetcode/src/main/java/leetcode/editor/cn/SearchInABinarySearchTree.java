package leetcode.editor.cn;

//给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
//
// 例如，
//
//
//给定二叉搜索树:
//
//        4
//       / \
//      2   7
//     / \
//    1   3
//
//和值: 2
//
//
// 你应该返回如下子树:
//
//
//      2
//     / \
//    1   3
//
//
// 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
// Related Topics 树
// 👍 136 👎 0

import com.sun.source.doctree.AttributeTree;

public class SearchInABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new SearchInABinarySearchTree().new Solution();
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
        public TreeNode searchBST(TreeNode root, int val) {
            // 深度遍历
            if (root == null) {
                return null;
            }
            return dfs(root, val);
        }

        public TreeNode dfs(TreeNode root, int val) {
            if (root == null) {
                return null;
            }
            if (root.val == val) {
                return root;
            }
            if (root.val<val){
                // val在右树
                return dfs(root.right, val);
            }else{
                // val在左树
                return dfs(root.left, val);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}