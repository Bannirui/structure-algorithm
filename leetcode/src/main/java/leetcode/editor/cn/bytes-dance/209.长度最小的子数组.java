/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) throw new IllegalArgumentException();
        int l=0, r=0;
        int ret=Integer.MAX_VALUE;
        int sum=0;
        while(r<len){
            sum+=nums[r];
            while(sum>=target){
                ret = Math.min(ret, r-l+1);
                sum-=nums[l++];
            }
            r++;
        }
        return ret==Integer.MAX_VALUE?0:ret;
    }
}
// @lc code=end

