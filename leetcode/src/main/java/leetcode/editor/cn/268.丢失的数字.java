/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 丢失的数字
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        int sum=0;
        // [0...n]
        for(int i=0;i<=nums.length;i++){
            sum+=i;
        }
        for(int num: nums){
            sum-=num;
        }
        return sum;
    }
}
// @lc code=end

