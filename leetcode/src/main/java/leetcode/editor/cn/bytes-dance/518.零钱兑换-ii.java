/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        int len=0; // the length of arr
        if(amount<0 || coins==null || (len=coins.length)==0) throw new RuntimeException("err");
        if(amount==0) return 1;
        int[] dp = new int[amount+1];
        dp[0]=1; // base case
        for(int i=0; i<len; i++){
            for(int j=coins[i]; j<=amount; j++){
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }

}
// @lc code=end

