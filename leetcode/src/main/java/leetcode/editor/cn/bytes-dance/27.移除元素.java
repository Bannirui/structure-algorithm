/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int len=0;
        if(nums==null || (len=nums.length)==0) return 0;
        int slow = -1;
        for(int fast=0; fast<len; fast++){
            if(nums[fast]!=val){
                nums[++slow]=nums[fast];
            }
        }
        return slow+1;
    }
}
// @lc code=end

