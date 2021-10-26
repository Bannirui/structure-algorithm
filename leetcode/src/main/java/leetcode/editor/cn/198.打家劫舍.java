/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        // dp[i] [0...i]
        int len = nums.length;
        // 偷第i家
        int[] dpWithRob = new int[len];
        // 不偷第i家
        int[] dpWithoutRob = new int[len];
        // base case
        dpWithRob[0] = nums[0];
        // [1...n]
        int max = Math.max(dpWithRob[0], dpWithoutRob[0]);
        for (int i = 1; i < len; i++) {
            // 偷第i家 第i-1家不能偷
            dpWithRob[i] = dpWithoutRob[i - 1] + nums[i];
            // 不偷第i家 第i-1家可偷可不偷
            dpWithoutRob[i] = Math.max(dpWithRob[i - 1], dpWithoutRob[i - 1]);
            // 当前最大金额
            max = Math.max(dpWithRob[i], dpWithoutRob[i]);
        }
        return max;
    }
}
// @lc code=end
