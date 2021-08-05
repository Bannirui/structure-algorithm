/*
 * @Author: dingRui
 * @Date: 2021-08-05 14:09:45
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-05 14:52:29
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        /**
         * 状态 第i天结束
         * 持有股票
         * 不持有股票 处于冷冻期
         * 不持有股票 不处于冷冻期
         */
        if (prices == null || prices.length == 0) {
            return 0;
        }
        /**
         * dp[i][0] 第i天结束 手里有一支过票
         * dp[i][1] 第i天结束 手里没有股票 处于冷冻期
         * dp[i][2] 第i天结束 手里没有股票 没有处于冷冻期
         */
        int[][] dp = new int[prices.length + 1][3];
        // base case
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        // 遍历每天股票的价格
        for (int i = 1; i < prices.length; i++) {
            // 股票要么i-1已经持有 要么i当天买的 i天能买股票说明i-1天不在冷冻期
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            // i天处于冷冻 说明i天卖股票了 i天之前手里是有股票的
            dp[i][1] = dp[i - 1][0] + prices[i];
            // i天手里没有股票 也没有处于冷冻期 说明i天没有操作 i-1天可能是没有股票在冷冻 也可能是没有股票也没在冷冻
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }
}
// @lc code=end
