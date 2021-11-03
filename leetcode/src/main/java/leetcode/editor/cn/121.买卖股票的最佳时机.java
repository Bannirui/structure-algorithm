/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // 一次买卖
        int len = prices.length;
        // 第i天结束手里有股票的收益
        int[] dpWith = new int[len];
        dpWith[0] = -prices[0];
        // 第i天结束手里没有股票的收益
        int[] dpWithout = new int[len];
        dpWithout[0]=0;
        // 推导
        for(int i=1;i<len;i++){
            // i-1没有股票->i有股票 买入
            // i-1有股票->i有股票 不动
            dpWith[i]=Math.max(-prices[i],dpWith[i-1]);
            // i-1没有股票->i没有股票 不动
            // i-1有股票->i没有股票 卖出
            dpWithout[i]=Math.max(dpWithout[i-1],dpWith[i-1]+prices[i]);
        }
        // 最后最大的收益一定是手里没有股票
        return dpWithout[len-1];
    }
}
// @lc code=end

