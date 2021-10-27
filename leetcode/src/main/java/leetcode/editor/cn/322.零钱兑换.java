import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i]
        int[] dp = new int[amount + 1];
        // base case 不换钱不需要硬币
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // 金额i
            int min = Integer.MAX_VALUE;
            // 使用硬币池中任意一个硬币都有对应的一个方案 最终挑选数量最少的
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    min = Math.min(min, dp[i - coins[j]]);
                }
            }
            if (min < Integer.MAX_VALUE) {
                min += 1;
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
// @lc code=end
