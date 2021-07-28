/*
 * @Author: dingrui
 * @Date: 2021-07-26 14:04:30
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-28 15:47:44
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        // dpMax[i] nums[0...i]乘积最大值
        // dpMin[i] nums[0...i]乘积最小值
        int[] dpMin = new int[nums.length];
        int[] dpMax = new int[nums.length];
        // base case
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int res = dpMax[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(nums[i], Math.max(nums[i] * dpMax[i - 1], nums[i] * dpMin[i - 1]));
            dpMin[i] = Math.min(nums[i], Math.min(nums[i] * dpMax[i - 1], nums[i] * dpMin[i - 1]));
            res = Math.max(res, dpMax[i]);
        }
        return res;
    }
}
// @lc code=end
