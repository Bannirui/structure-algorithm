/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        // base case
        dp[0]=0;
        for(int i=1;i<=n;i++){
            // 在[1...n-1]中找和最小
            int min=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                min=Math.min(min, dp[i-j*j]);
            }
            // 找到了一个数j
            dp[i]=min+1;
        }
        return dp[n];
    }
}
// @lc code=end

