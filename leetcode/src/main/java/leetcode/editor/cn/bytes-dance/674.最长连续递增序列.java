/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 */

// @lc code=start
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int len =0;
        if(nums==null || (len=nums.length)==0) throw new IllegalArgumentException();
        int ret=1; // the min length
        int[] dp = new int[len];
        dp[0] = 1; // base case
        for(int i=1; i<len; i++){
            dp[i]=1;
            if(nums[i]>nums[i-1]) dp[i]=dp[i-1]+1;
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
// @lc code=end

