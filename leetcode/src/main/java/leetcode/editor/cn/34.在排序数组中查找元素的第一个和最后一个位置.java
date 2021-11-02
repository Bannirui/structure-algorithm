/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // 第一个=target脚标
        int first = this.bs(nums, target, false);
        // 第一个>target脚标
        int second =this.bs(nums, target, true)-1;
        if(first<=second && first<nums.length&&second<nums.length&&nums[first]==target&&nums[second]==target){
            return new int[]{first, second};
        }
        return new int[]{-1,-1};

    }


    // greater=true nums[...]中找第一个>target
    // greater=false nums[...]中找第一个=target
    private int bs(int[] nums, int target, boolean greater){
        int l=0, r=nums.length-1;
        // 如果整个数组都是一样的数字
        int res=nums.length;
        while(l<=r){
            int mid = l+((r-l)>>>1);
            if(greater){
                // 找第一个>target
                if(nums[mid]==target){
                    // 找[mid+1...r]
                    l=mid+1;
                }else if(nums[mid]>target){
                    // [l...mid-1]中可能
                    res = mid;
                    r=mid-1;
                }else{
                    // 肯定在[mid+1...r]
                    l=mid+1;
                }
            }else{
                // 找第一个=target
                if(nums[mid]==target){
                    // [l...mid-1]中可能还有target
                    res=mid;
                    r=mid-1;
                }else if(nums[mid]>target){
                    // target在[l...mid-1]
                    r=mid-1;
                }else{
                    // target在[mid+1...r]
                    l=mid+1;
                }
            }
        }
        return res;
    }
}
// @lc code=end

