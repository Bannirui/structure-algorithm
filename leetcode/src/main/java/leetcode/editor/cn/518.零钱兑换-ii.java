/*
 * @Author: dingrui
 * @Date: 2021-07-22 23:33:56
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-22 23:54:32
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        // 暴力递归
        // if (coins.length == 0) {
        // return amount == 0 ? 1 : 0;
        // }
        // return this.dfs(coins, 0, amount);

        // dp
        int[] dp = new int[amount + 1];
        // 初始化 凑出0元
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }

    // 在coins[index...]中凑出amount
    private int dfs(int[] coins, int index, int amount) {
        // base case
        if (amount == 0) {
            return 1;
        }
        if (index == coins.length) {
            return 0;
        }
        int counts = 0;
        for (int i = 0; coins[index] * i <= amount; i++) {
            // 用i个coins[index]硬币
            counts += dfs(coins, index + 1, amount - coins[index] * i);
        }
        return counts;
    }
}
// @lc code=end
