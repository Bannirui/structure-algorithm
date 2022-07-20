/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) throw new IllegalArgumentException();
        if(len==1) return nums[0];
        int l=0, r=len-1;
        while(l<r){
            int mid=l+((r-l)>>1);
            int midV=nums[mid];
            if(midV<=nums[len-1]) r=mid;
            else l=mid+1;
        }
        return nums[l];
    }
}
// @lc code=end

