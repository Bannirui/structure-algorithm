/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        // base case
        dp[0]=1;
        int maxLen=1;
        for(int i=1;i<nums.length;i++){
            int historyMaxLen=0;
            for(int j=0;j<i;j++){
                // [j...i]升序
                if(nums[i]>nums[j]){
                    historyMaxLen=Math.max(historyMaxLen, dp[j]);
                }
            }
            dp[i]=historyMaxLen+1;
            // 更新全局
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
// @lc code=end

