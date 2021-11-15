/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private static final String NULL_REPLACE = "N";
    private static final String END_REPLACE = "#";


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return this.dfsSerialize(root);
    }

    private String dfsSerialize(TreeNode root){
        String res="";
        // base case
        if(root==null){
            res+=NULL_REPLACE;
            res+=END_REPLACE;
            return res;
        }
        // root-left-right
        res+=String.valueOf(root.val);
        res+=END_REPLACE;
        res += this.dfsSerialize(root.left);
        res += this.dfsSerialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 1#2#.....
        String[] nodeArr = data.split(END_REPLACE);
        List<String> nodeList = new ArrayList<>(Arrays.asList(nodeArr));
        return this.dfsDeserialize(nodeList);
    }

    private TreeNode dfsDeserialize(List<String> nodeList){
        // base case
        if(nodeList.get(0).equals(NULL_REPLACE)){
            nodeList.remove(0);
            return null;
        }
        // root-left-right
        TreeNode root = new TreeNode(Integer.valueOf(nodeList.get(0)));
        nodeList.remove(0);
        root.left=this.dfsDeserialize(nodeList);
        root.right=this.dfsDeserialize(nodeList);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

