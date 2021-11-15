/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=this.bs(nums, target, false);
        int r=this.bs(nums, target, true);
        return new int[]{l,r};
    }
    
    private int bs(int[] nums, int target, boolean greater){
        int l=0;
        int r=nums.length-1;
        int res=-1;
        while(l<=r){
            int mid = l+((r-l)>>>1);
            if(greater){
                // 找更大
                if(nums[mid]==target){
                    // 可能在右边
                    res=mid;
                    l=mid+1;
                } else if(nums[mid]<target){
                    // 一定在右边
                    l=mid+1;
                }else{
                    // 一定在左边
                    r=mid-1;
                }
            }else{
                // 找更小
                if(nums[mid]==target){
                    // 可能在左边
                    res=mid;
                    r=mid-1;
                }else if(nums[mid]<target){
                    // 一定在右边
                    l=mid+1;
                }else{
                    // 一定在左边
                    r=mid-1;
                }
            }
        }
        return res;
    }
}
// @lc code=end

