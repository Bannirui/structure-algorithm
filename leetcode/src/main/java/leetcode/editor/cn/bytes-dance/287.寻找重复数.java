/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) throw new RuntimeException("err: param");
        // mapping
        for(int i=0; i<len; i++){
            while(i+1!=nums[i] && nums[i]!=nums[nums[i]-1]){
                int cur = nums[i];
                int idx=cur-1;
                nums[i]=nums[idx];
                nums[idx]=cur;
            }
        }
        // find
        for(int i=0; i<len; i++){
            if(i+1!=nums[i]) return nums[i];
        }
        return -1; // not found the dest num
    }
}
// @lc code=end

