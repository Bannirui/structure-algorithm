/*
 * @Author: dingrui
 * @Date: 2021-07-12 21:32:07
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 21:32:48
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1920 lang=java
 *
 * [1920] 基于排列构建数组
 */

// @lc code=start
class Solution {
    public int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }
}
// @lc code=end
