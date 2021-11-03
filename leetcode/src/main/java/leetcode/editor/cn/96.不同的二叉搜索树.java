/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        // dp[i] [1...i]个节点构建出来的搜索二叉树数量
        // base case
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            // [1...i]中挑选出来root节点
            for(int j=1;j<=i;j++){
                // 以j为root [1...j-1]j-1个节点为左子树 [j+1...i]i-j个节点为右子树
                dp[i] += 1*dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
// @lc code=end

