/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        // 遇到0往后挪一个位置
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                // 当前不是0
                continue;
            }else{
                // 当前是0 在[i+1...]找第一个不是0的换位置
                for(int j=i+1;j<nums.length;j++){
                    if(nums[j]!=0){
                        this.swap(nums,i,j);
                        break;
                    }
                }
            }
        }
    }

    private void swap(int[] nums, int start, int end){
        int tmp=nums[start];
        nums[start]=nums[end];
        nums[end]=tmp;
    }
}
// @lc code=end

