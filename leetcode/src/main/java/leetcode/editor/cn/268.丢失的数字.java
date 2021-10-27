/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 丢失的数字
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        // 求和
        int len = nums.length;
        int sum = 0;
        while (len != 0) {
            sum += len;
            len--;
        }
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}
// @lc code=end
