/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        // corner condition
        int len = 0;
        if(nums==null || (len=nums.length)==0) return 0;
        /*
        dp[i] at the end of i
        */
        int[] dp =new int[len];
        dp[0] = 1; // base case
        int ret = dp[0]; // record the max length for sub str
        for(int i=1; i<len; i++){
            dp[i]=1;
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){ // generate new sub str
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
// @lc code=end

