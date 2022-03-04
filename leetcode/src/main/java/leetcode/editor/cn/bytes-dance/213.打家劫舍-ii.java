/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) throw new IllegalArgumentException();
        if(len==1) return nums[0];
        if(len==2) return Math.max(nums[0], nums[1]);
        return Math.max(this.rob(nums, 0, len-2), this.rob(nums, 1, len-1));
    }

    private int rob(int[] nums, int start, int end){
        int dp2=0;
        int dp1=0;
        for(int i=start;i<=end;i++){
            int dp=Math.max(nums[i]+dp2,dp1);
            dp2=dp1;
            dp1=dp;
        }
        return dp1;
    }
}
// @lc code=end

