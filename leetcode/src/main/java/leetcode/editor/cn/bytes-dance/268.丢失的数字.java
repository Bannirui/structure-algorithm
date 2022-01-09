/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 丢失的数字
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) throw new RuntimeException("err");
        int sum = (0+len)*(len+1)/2;
        for(int num: nums) sum-=num;
        return sum;
    }
}
// @lc code=end

