package leetcode.editor.cn;

//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索 
// 👍 673 👎 0

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
        // TreeNode treeNode = solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
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
    }

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            // 随便选取数组中第一个元素作为root根节点 这样添加节点的话会导致树退化成单链表 怎么保证树高差呢 所以这个地方不能随便选 应该尽量选中间的 可以尽量保证树的平衡 但是要保证树高差不超过1 就涉及到avl旋转了
            if (nums.length >= 1) {
                int mid = nums.length >> 1;
                TreeNode root = new TreeNode(nums[mid]);
                for (int i = 0; i < nums.length; i++) {
                    if (i != mid) {
                        addNode(root, nums[i]);
                    }
                }
                return root;
            }
            return null;
        }

        public TreeNode addNode(TreeNode root, int value) {
            if (root == null) {
                return root;
            }
            // root是根节点 遍历比较插值
            if (value > root.val) {
                // 挂右子树
                if (root.right == null) {
                    // 右子树为空 直接挂上去
                    root.right = new TreeNode(value);
                } else {
                    // 右子树不为空 还得继续遍历右子树
                    addNode(root.right, value);
                }
            } else {
                // 挂左子树
                if (root.left == null) {
                    // 左子树为空 直接挂上去
                    root.left = new TreeNode(value);
                } else {
                    // 左子树不为空 遍历
                    addNode(root.left, value);
                }
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}