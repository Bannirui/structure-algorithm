/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) return 0;
        int[][] dp = new int[len][2];
        dp[0][1]=nums[0]; // base case
        for(int i=1; i<len;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0]+nums[i];
        }
        return Math.max(dp[len-1][0], dp[len-1][1]);
    }
}
// @lc code=end

