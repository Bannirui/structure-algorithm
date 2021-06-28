/*
 * @Author: dingrui
 * @Date: 2021-06-25 17:01:32
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-28 21:51:03
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=908 lang=java
 *
 * [908] 最小差值 I
 */

// @lc code=start
class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int res = (max - k) - (min + k);
        return Math.max(0, res);
    }
}
// @lc code=end
