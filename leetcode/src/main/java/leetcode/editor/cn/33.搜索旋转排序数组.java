/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        // 目标数组中存在一个临界点i [0...i]升序 [i+1...]升序
        // bs
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid = l+((r-l)>>>1);
            if(nums[mid]==target){
                // 找到了目标值
                return mid;
            }
            if(nums[l]<=nums[mid]){
                // [l...mid]升序
                if(nums[l]<=target&&target<=nums[mid]){
                    // target 落在升序区间
                    r =mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                // [mid...r]升序
                if(nums[mid]<=target&&target<=nums[r]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        // 没找到
        return -1;
    }
}
// @lc code=end

