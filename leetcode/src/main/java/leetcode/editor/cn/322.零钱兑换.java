/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i]换i钱的货币数量
        int[] dp = new int[amount+1];
        // base case
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            int minCnt=Integer.MAX_VALUE;
            for(int coin:coins){
                if(i-coin>=0&&dp[i-coin]!=Integer.MAX_VALUE){
                    minCnt = Math.min(dp[i-coin], minCnt);
                }
            }
            dp[i]=minCnt==Integer.MAX_VALUE?Integer.MAX_VALUE:minCnt+1;
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
// @lc code=end

