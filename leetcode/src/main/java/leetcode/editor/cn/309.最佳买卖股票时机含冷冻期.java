/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // 第i天结束后的最大收益
        // dp[i][0] 手上有股票
        // dp[i][1] 手上没有股票 处于冷冻期
        // dp[i][2] 手上没有股票 没有冷冻期
        int[][] dp = new int[prices.length][3];
        // base case
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        // 推导
        for(int i=1; i<prices.length; i++){
            // 第i天结束
            // 手上有股票 -> i-1天持有的股票没卖 i-1天没有股票现买的
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);
            // 手上没有股票 处于冷冻期 -> i-1天的股票今天卖了
            dp[i][1] = dp[i-1][0]+prices[i];
            // 手上没有股票 不处于冷冻期 -> i-1没有股票并且是冷冻期 i-1没有股票并且不是冷冻期
            dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2]);
        }
        // 最后一天手上没有股票的收益是最大的
        return Math.max(dp[prices.length-1][1],dp[prices.length-1][2]);
    }
}
// @lc code=end

