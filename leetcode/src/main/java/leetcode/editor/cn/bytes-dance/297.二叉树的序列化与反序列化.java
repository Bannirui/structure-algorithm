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

    // preorder
    // ! as the end of each node and # as the NULL ptr
    private String str = "";

    private TreeNode root=null;

    private static final String END_STR = "!";
    private static final String NULL_STR="#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        this.serDfs(root);
        return this.str; 
    }

    private void serDfs(TreeNode root){
        if(root==null){
            // base case
            this.str=this.str+NULL_STR+END_STR;
            return;
        }
        this.str=this.str+root.val+END_STR;
        this.serDfs(root.left);
        this.serDfs(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.length()==0) return null;
        String[] nodeArr = data.split(END_STR);
        List<String> nodeList = new LinkedList<String>(Arrays.asList(nodeArr));
        return this.deserDfs(nodeList);
    }

    private TreeNode deserDfs(List<String> nodeList){
        if(Objects.equals(nodeList.get(0),NULL_STR)){
            nodeList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodeList.get(0)));
        nodeList.remove(0);
        root.left=this.deserDfs(nodeList);
        root.right=this.deserDfs(nodeList);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

