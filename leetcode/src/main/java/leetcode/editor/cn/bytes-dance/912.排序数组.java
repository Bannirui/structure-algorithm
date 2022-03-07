/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        this.quickSort(nums, 0, nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r){
        if(l>=r) return;
        int p=this.partition(nums, l, r);
        this.quickSort(nums,l,p-1);
        this.quickSort(nums,p+1,r);
    }

    private int partition(int[] nums, int l, int r){
        int base=nums[l];
        while(l<r){
            while(l<r && base<nums[r]) r--;
            if(l<r) nums[l++]=nums[r];
            while(l<r && nums[l]<=base) l++;
            if(l<r) nums[r--]=nums[l];
        }
        nums[l]=base;
        return l;
    }
}
// @lc code=end

