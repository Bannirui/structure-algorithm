/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) throw new IllegalArgumentException();
        // [i...i+1] asc
        int i=len-2;
        while(i>=0 && nums[i]>=nums[i+1]) i--;
        if(i>=0){
            int j=len-1;
            while(j>=0 && nums[i]>=nums[j]) j--;
            this.swap(nums, i, j);
        }
        this.reverse(nums, i+1, len-1);
    }

    private void swap(int[] nums, int idx1, int idx2){
        if(nums==null || idx1<0 || idx1>=nums.length || idx2<0 || idx2>=nums.length) throw new IllegalArgumentException();
        int tmp = nums[idx1];
        nums[idx1]=nums[idx2];
        nums[idx2]=tmp;
    }

    // [start...end] inclusive
    private void reverse(int[] nums, int start, int end){
        if(nums==null||start<0||start>=nums.length||end<0||end>=nums.length||start>end) throw new IllegalArgumentException();
        while(start<end) this.swap(nums, start++, end--);
    }
}
// @lc code=end

