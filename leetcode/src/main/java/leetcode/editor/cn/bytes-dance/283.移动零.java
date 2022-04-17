/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) return;
        int i=0, j=0;
        while(j<len){
            if(nums[j]!=0){
                this.swap(nums,i,j);
                i++;
            }
            j++;
        }
    }

    private void swap(int[] nums, int i, int j){
        int len=0;
        if(nums==null || (len=nums.length)==0) throw new IllegalArgumentException();
        if(i<0 || i>=len || j<0 || j>= len) throw new IllegalArgumentException();
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
// @lc code=end

