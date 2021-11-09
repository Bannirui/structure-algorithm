/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        // bs
        int l=0, r=nums.length-1;
        while(l<=r){
            int mid = l+((r-l)>>>1);
            if(nums[mid]==target){
                // 找到了
                return mid;
            }else if(nums[mid]>target){
                // 在左边
                r=mid-1;
            }else{
                // 在右边
                l=mid+1;
            }
        }
        // 遍历完都没找到
        return -1;
    }
}
// @lc code=end

