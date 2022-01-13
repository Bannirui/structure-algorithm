/*
 * @lc app=leetcode.cn id=449 lang=java
 *
 * [449] 序列化和反序列化二叉搜索树
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

    private static final String END_NODE = "!";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ret = new StringBuilder();
        this.serializeDfs(root, ret);
        return ret.toString();
    }

    private void serializeDfs(TreeNode root, StringBuilder ret){
        if(root==null) return;
        ret.append(root.val).append(END_NODE);
        this.serializeDfs(root.left, ret);
        this.serializeDfs(root.right, ret);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.length()==0) return null;
        String[] strArr = data.split(END_NODE);
        int len=0;
        if(strArr==null || (len=strArr.length)==0) return null;
        Integer[] numArr = new Integer[len];
        for(int i=0; i<len; i++) numArr[i]=Integer.parseInt(strArr[i]);
        return this.deserializeDfs(numArr, 0, len-1);
    }

    private TreeNode deserializeDfs(Integer[] arr, int lo, int hi){
        if(lo>hi) return null;
        // root=lo
        // left=[lo+1...idx-1]
        // right=[idx...hi]
        TreeNode root=new TreeNode(arr[lo]);
        int idx4Right = hi+1;
        for(int i=lo+1; i<=hi; i++){
            if(arr[i]>arr[lo]){
                idx4Right=i;
                break;
            }
        }
        root.left=this.deserializeDfs(arr,lo+1,idx4Right-1);
        root.right=deserializeDfs(arr,idx4Right,hi);
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

