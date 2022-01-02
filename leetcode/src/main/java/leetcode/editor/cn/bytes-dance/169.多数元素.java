/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) throw new RuntimeException("error");
        // int->Integer
        Arrays.sort(nums);
        return nums[len>>1];
    }
}
// @lc code=end

