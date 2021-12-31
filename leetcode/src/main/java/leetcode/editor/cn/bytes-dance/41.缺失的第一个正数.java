/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) return 1;
        // iterator
        LABEL:
        for(int i=0; i<len; i++){
            while(nums[i]>0 && nums[i]<len && nums[i]!=i+1){
                if(nums[nums[i]-1]==nums[i]){
                    continue LABEL;
                }
                // swap
                int srcVal = nums[i];
                int destIdx = nums[i]-1;
                nums[i] = nums[destIdx]; // dest->src
                nums[destIdx] = srcVal ; // src->dest
            }
        }

        for(int i=0;i<len;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return len+1;
    }
}
// @lc code=end

