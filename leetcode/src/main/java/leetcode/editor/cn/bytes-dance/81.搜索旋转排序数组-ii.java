/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        int len=0;
        if(nums==null || (len=nums.length)==0) throw new IllegalArgumentException();
        int l=0, r=len-1;
        while(l<=r){
            int mid = l+((r-l)>>1);
            if(target==nums[mid]) return true;
            if(nums[l]==nums[mid] && nums[mid]==nums[r]){
                l++;
                r--;
            }else if(nums[l]<=nums[mid]){
                if(nums[l]<=target && target<=nums[mid]) r=mid-1;
                else l=mid+1;
            }else{
                if(nums[mid]<=target && target<=nums[len-1]) l=mid+1;
                else r=mid-1;
            }
        }
        return false; // not found target
    }
}
// @lc code=end

