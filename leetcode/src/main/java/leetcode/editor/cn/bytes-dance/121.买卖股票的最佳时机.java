/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        /*
        dp
        only once trade
        dp[i][0] state=out-of-hand at the end of day
        dp[i][1] state=in-hand at the end of day
        */
        // corner condition
        int len = 0;
        if((len=prices.length)==0) return 0;
        int[][] dp = new int[len][2];
        int ret = 0; // record the best benefit
        // base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        // iterator
        for(int i=1; i<len; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]); // prev state: out-of-hand || in-hand
            dp[i][1] = Math.max(-prices[i], dp[i-1][1]); // prev state: out-of-hand || in-hand
            ret = Math.max(ret, Math.max(dp[i][0], dp[i][1]));
        }
        return ret;
    }
}
// @lc code=end

