/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int len=0;
        if(nums==null || (len=nums.length)==0) return -1; // invalid param
        int l=0, r=len-1;
        while(l<=r){
            int mid = l+((r-l)>>1);
            if(nums[mid]==target) return mid;
            if(nums[mid]>target){
                r--;
            }else{
                l++;
            }
        }
        return -1;
    }
}
// @lc code=end

