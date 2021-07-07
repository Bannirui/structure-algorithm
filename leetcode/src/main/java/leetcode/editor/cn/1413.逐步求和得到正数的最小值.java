/*
 * @Author: dingrui
 * @Date: 2021-07-07 16:55:31
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-07 17:04:12
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1413 lang=java
 *
 * [1413] 逐步求和得到正数的最小值
 */

// @lc code=start
class Solution {
    public int minStartValue(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            minSum = Math.min(minSum, sum);
        }
        return minSum >= 0 ? 1 : (-minSum + 1);
    }
}
// @lc code=end
