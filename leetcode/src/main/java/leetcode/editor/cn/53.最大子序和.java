/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        // dp[i]以i结尾的最大和
        int[] dp= new int[nums.length];
        // base case
        dp[0] = nums[0];
        int res=dp[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            res=Math.max(res, dp[i]);
        }
        return res;
    }
}
// @lc code=end

