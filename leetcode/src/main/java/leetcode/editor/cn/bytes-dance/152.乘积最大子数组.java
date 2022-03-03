/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) throw new IllegalArgumentException();
        int[][] dp = new int[len][2];
        // base case
        dp[0][0]=nums[0];
        dp[0][1]=nums[0];
        int ret=nums[0];
        for(int i=1;i<len;i++){
            dp[i][0]=Math.max(nums[i],Math.max(dp[i-1][0]*nums[i],dp[i-1][1]*nums[i]));
            dp[i][1]=Math.min(nums[i],Math.min(dp[i-1][0]*nums[i],dp[i-1][1]*nums[i]));
            ret=Math.max(ret, dp[i][0]);
        }
        return ret;
    }
}
// @lc code=end

