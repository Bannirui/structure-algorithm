import java.util.Arrays;

/*
 * @Author: dingrui
 * @Date: 2021-07-17 16:01:31
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-17 16:28:12
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0 || coins.length == 0) {
            return 0;
        }
        /**
         * 金额面值数组[x, y, z]
         * dp[i]
         * 组成i元的最小金币数量
         *     dp[i-x]
         *     dp[i-y]
         *     dp[i-z]
         */
        int[] dp = new int[amount + 1];
        // base case
        Arrays.fill(dp, -1);
        // 0元不需要硬币
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            if (0 <= coins[i] && coins[i] <= amount) {
                dp[coins[i]] = 1;
            }
        }
        // 填表
        for (int i = 1; i < dp.length; i++) {
            // -1是待处理的
            if (dp[i] == -1) {
                int minCoins = Integer.MAX_VALUE;
                for (int j = 0; j < coins.length; j++) {
                    int curCoins = i - coins[j] >= 0 ? dp[i - coins[j]] : -1;
                    minCoins = curCoins == -1 ? minCoins : Math.min(minCoins, curCoins);
                }
                dp[i] = (minCoins == Integer.MAX_VALUE || minCoins == -1) ? -1 : minCoins + 1;
            }
        }
        return dp[amount];
    }
}
// @lc code=end
