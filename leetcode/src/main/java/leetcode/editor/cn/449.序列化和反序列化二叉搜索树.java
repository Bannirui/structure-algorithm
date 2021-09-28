import java.util.Objects;

import leetcode.editor.cn.BalancedBinaryTree.TreeNode;

/*
 * @lc app=leetcode.cn id=449 lang=java
 *
 * [449] 序列化和反序列化二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 先序: root->left->right
        if (root == null) {
            return "#!";
        }
        String res = root.val + "!";
        res += this.serialize(root.left);
        res += this.serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 先序: root->left->right
        String[] nodeStrArr = data.split("!");
        Queue<String> nodeStrQ = new LinkedList<>();
        for (String nodeStr : nodeStrArr) {
            nodeStrQ.offer(nodeStr);
        }
        return this.deserializedDfs(nodeStrQ);
    }

    private TreeNode deserializedDfs(Queue<String> q) {
        String nodeStr = q.poll();
        if (Objects.equals(nodeStr, "#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(nodeStr));
        root.left = this.deserializedDfs(q);
        root.right = this.deserializedDfs(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
// @lc code=end
