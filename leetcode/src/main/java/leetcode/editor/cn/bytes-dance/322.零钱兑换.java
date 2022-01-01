/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<0) throw new RuntimeException("error"); // corner condition
        int len=0;
        if(coins==null || (len=coins.length)==0 || amount==0) return 0;
        int[] dp =new int[amount+1]; 
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // the base case is dp[0]=0
        for(int i=1; i<=amount; i++){
            for(int j=0;j<len;j++){
                if(i-coins[j]>=0 && dp[i-coins[j]]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
// @lc code=end

