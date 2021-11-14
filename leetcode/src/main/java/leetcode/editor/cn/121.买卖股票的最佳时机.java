/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // 一次买卖
        // dp[...][0] 没股票
        // dp[...][1] 有股票
        int[][] dp = new int[prices.length][2];
        // base case
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1;i<prices.length;i++){
            // i没股票 i-1没股票 i-1有股票
            // i有股票 i-1没股票 i-1有股票
            dp[i][0]=Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(-prices[i],dp[i-1][1]);
        }
        // 最后一天没股票
        return dp[prices.length-1][0];
    }
}
// @lc code=end

