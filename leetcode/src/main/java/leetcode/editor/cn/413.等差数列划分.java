import java.util.Arrays;

/*
 * @Author: dingRui
 * @Date: 2021-08-31 09:45:58
 * @LastEditors: dingRui
 * @LastEditTime: 2021-09-03 16:03:05
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=413 lang=java
 *
 * [413] 等差数列划分
 */

// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = 0;
        if (nums == null || (len = nums.length) < 3) {
            return 0;
        }
        // dp[i]语义:nums[0...i]等差数列个数
        int[] dp = new int[len];
        int res = 0;
        for (int i = 2; i < len; i++) {
            dp[i] = (nums[i] + nums[i - 2] == 2 * nums[i - 1]) ? (dp[i - 1] + 1) : 0;
            res += dp[i];
        }
        return res;
    }
}
// @lc code=end
