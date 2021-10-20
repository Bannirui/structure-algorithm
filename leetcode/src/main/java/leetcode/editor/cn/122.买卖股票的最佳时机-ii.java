/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution
{
    public int maxProfit(int[] prices)
    {
        // 必须在购买之前先卖掉之前的股票
        // 每天结束的股票状态就是2种 持有股票 不持有股票
        int[] with = new int[prices.length];
        int[] without = new int[prices.length];
        // base case 第1天
        with[0] = -prices[0];
        without[0] = 0;
        // 从第2天开始遍历
        for (int i = 1; i < prices.length; i++)
        {
            // 之前没股票现在买入 之前有股票现在不卖也不买
            with[i] = Math.max(without[i - 1] - prices[i], with[i - 1]);
            // 之前没股票现在不买也不卖 之前有股票现在卖掉
            without[i] = Math.max(without[i - 1], with[i - 1] + prices[i]);
        }
        // 股票都完成交易 手里不再持有股票的场景收益才是最高的
        return without[prices.length - 1];
    }
}
// @lc code=end
