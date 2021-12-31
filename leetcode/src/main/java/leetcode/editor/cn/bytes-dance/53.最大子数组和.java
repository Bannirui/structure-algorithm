/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        /*
        dp
        dp[i] [...i] the max sum to the end
        */
        int len = 0;
        if((len=nums.length)==0) return 0;
        int ret = Integer.MIN_VALUE; // record the max sum
        int[] dp = new int[len];
        dp[0] = nums[0]; // base case
        ret = Math.max(ret, dp[0]);
        for(int i=1; i<len; i++){
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            ret = Math.max(dp[i], ret);
        }
        return ret;
    }
}
// @lc code=end

