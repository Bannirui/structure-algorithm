/*
 * @Author: dingrui
 * @Date: 2021-07-12 21:34:59
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 21:42:11
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1913 lang=java
 *
 * [1913] 两个数对之间的最大乘积差
 */

// @lc code=start
class Solution {
    public int maxProductDifference(int[] nums) {
        // 都是正数 两个最大 两个最小
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            // 最大值
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
            // 最小值
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return (max1 * max2) - (min1 * min2);
    }
}
// @lc code=end
