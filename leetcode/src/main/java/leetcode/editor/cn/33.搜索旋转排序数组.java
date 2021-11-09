/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        // bs
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=l+((r-l)>>>1);
            if(nums[mid]==target){
                // 找到了
                return mid;
            }
            // [l...mid] [mid...r]
            if(nums[l]<=nums[mid]){
                // [l...mid-1]升序
                if(nums[l]<=target && target<=nums[mid]){
                    // target落在[l...mid]
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                // [mid+1...r]升序
                if(nums[mid]<=target&&target<=nums[r]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        // 不存在
        return -1;
    }
}
// @lc code=end

