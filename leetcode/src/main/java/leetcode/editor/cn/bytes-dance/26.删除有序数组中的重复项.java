/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) return 0;
        int fast=1, slow=1;
        while(fast<len){
            if(nums[fast]!=nums[fast-1]){
                nums[slow++]=nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
// @lc code=end

