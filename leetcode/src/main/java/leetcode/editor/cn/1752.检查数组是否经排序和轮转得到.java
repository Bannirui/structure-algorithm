/*
 * @Author: dingrui
 * @Date: 2021-07-12 14:37:04
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 14:57:20
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1752 lang=java
 *
 * [1752] 检查数组是否经排序和轮转得到
 */

// @lc code=start
class Solution {
    public boolean check(int[] nums) {
        boolean flag = nums[0] >= nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            // flag为false的情况下只能出现一次递减
            if (nums[i - 1] > nums[i]) {
                if (flag) {
                    flag = false;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end
