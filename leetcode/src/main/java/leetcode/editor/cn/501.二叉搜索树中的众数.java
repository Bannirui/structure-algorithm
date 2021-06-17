import java.util.List;

/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    int maxCount;
    int curCount, curValue;

    public int[] findMode(TreeNode root) {
        // 极限情况：左=根=右
        // 暴力求解 所有节点的值遍历出来 对值计数
        List<Integer> tmp = new ArrayList<>();
        dfs(root, tmp);
        int[] res = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }

    // 中序遍历
    public void dfs(TreeNode root, List<Integer> tmp) {
        if (root == null) {
            return;
        }
        dfs(root.left, tmp);
        update(root.val, tmp);
        dfs(root.right, tmp);
    }

    public void update(int value, List<Integer> tmp) {
        if (value == curValue) {
            // 还是上次的那个值 计数加1
            curCount++;
        } else {
            // 新的值
            curValue = value;
            curCount = 1;
        }
        if (curCount == maxCount) {
            // 多个众数出现
            tmp.add(value);
        }
        if (curCount > maxCount) {
            // 众数出现
            tmp.clear();
            tmp.add(value);
            maxCount = curCount;
        }
    }
}
// @lc code=end
