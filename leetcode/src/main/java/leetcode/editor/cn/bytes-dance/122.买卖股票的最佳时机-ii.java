/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        /*
        more than one trade
         */
        int len=0; // the length of arr
        if(prices==null || (len=prices.length)==0) return 0; //param check
        /*
        [...][0]: out-of-hand at the end of day
        [...][1]: in-hand at the end of day
         */
        int[][] dp = new int[len][2]; 
        // base case
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1; i<len; i++){ // iterator frim 1...
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][0]-prices[i], dp[i-1][1]);
        }
        return dp[len-1][0];
    }
}
// @lc code=end

