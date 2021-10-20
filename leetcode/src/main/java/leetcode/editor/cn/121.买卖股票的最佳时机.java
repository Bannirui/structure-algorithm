/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution
{
    public int maxProfit(int[] prices)
    {
        // with[i] 第i天结束手上有股票的利润
        int[] with = new int[prices.length];
        // without[i] 第i天结束手上没有股票的收益
        int[] without = new int[prices.length];
        // base case
        with[0] = -prices[0];
        without[0] = 0;
        // 从第二天遍历
        for (int i = 1; i < prices.length; i++)
        {
            with[i] = Math.max(with[i - 1], -prices[i]);
            without[i] = Math.max(with[i - 1] + prices[i], without[i - 1]);
        }
        // 一次买卖 最后手上肯定没有股票
        return without[prices.length - 1];
    }
}
// @lc code=end
