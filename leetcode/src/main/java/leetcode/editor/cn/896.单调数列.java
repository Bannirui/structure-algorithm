/*
 * @Author: dingrui
 * @Date: 2021-06-28 21:52:01
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-28 21:58:10
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=896 lang=java
 *
 * [896] 单调数列
 */

// @lc code=start
class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean inc = false, desc = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                // 递增
                inc = true;
            }
            if (nums[i] < nums[i - 1]) {
                // 递减
                desc = true;
            }
        }
        // 同时存在 递增段和递减段
        return !(inc && desc);
    }
}
// @lc code=end
