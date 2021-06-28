/*
 * @lc app=leetcode.cn id=896 lang=java
 *
 * [896] 单调数列
 */

// @lc code=start
class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean asc = false, desc = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                // 递增
                asc = true;
            }
            if (nums[i] < nums[i - 1]) {
                // 递减
                desc = true;
            }
        }
        return !(asc & desc);
    }
}
// @lc code=end
