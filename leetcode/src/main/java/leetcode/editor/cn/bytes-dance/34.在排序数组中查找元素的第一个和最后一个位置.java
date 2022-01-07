/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[]{-1,-1};
        int firstIdx = this.bs(nums, 0, nums.length-1, target, false);
        int lastIdx = this.bs(nums, 0, nums.length-1, target, true);
        return new int[]{firstIdx, lastIdx};
    }

    private int bs(int[] nums, int l, int r, int target, boolean bigger){
        int ret=-1;
        while(l<=r){
            int mid = l+((r-l)>>1);
            if(nums[mid]==target){
                ret=mid;
                if(bigger){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }else if(nums[mid]<target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ret;
    }
}
// @lc code=end

