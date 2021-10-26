/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        // base case
        int len = 0;
        if (nums == null || (len = nums.length) == 0) {
            throw new RuntimeException();
        }
        // dp[i]以nums[i]结尾的连续子数组
        int[] dpMax = new int[len];
        int[] dpMin = new int[len];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        // 从[1...]开始遍历
        for (int i = 1; i < len; i++) {
            // 以i结尾 要么i单独成序列 要么i加到i-1形成的序列
            dpMax[i] = Math.max(nums[i], Math.max(nums[i] * dpMax[i - 1], nums[i] * dpMin[i - 1]));
            dpMin[i] = Math.min(nums[i], Math.min(nums[i] * dpMax[i - 1], nums[i] * dpMin[i - 1]));
        }
        // dpMax遍历找数组中不同元素结尾的最大值
        int res = Integer.MIN_VALUE;
        for (int max : dpMax) {
            res = Math.max(res, max);
        }
        return res;
    }
}
// @lc code=end
