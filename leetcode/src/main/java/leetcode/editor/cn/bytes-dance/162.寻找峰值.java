/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) throw new IllegalArgumentException();
        if(len==1) return 0;
        for(int i=0;i<len;i++){
            if(i==0){
                if(nums[i]>nums[i+1]) return i;
            }
            else if(i==len-1){
                 if(nums[i]>nums[i-1]) return i;
            }
            else if(nums[i]>nums[i-1] && nums[i]>nums[i+1]) return i;
        }
        return -1;
    }
}
// @lc code=end

