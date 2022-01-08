/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) throw new RuntimeException("err");
        int[] ret = new int[len];
        for(int i=0,j=len-1,res=len-1;i<=j;){
            if(nums[i]*nums[i]>=nums[j]*nums[j]){
                ret[res--]=nums[i]*nums[i];
                i++;
            }else{
                ret[res--]=nums[j]*nums[j];
                j--;
            }
        }
        return ret;
    }
}
// @lc code=end

