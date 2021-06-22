/*
 * @Author: dingrui
 * @Date: 2021-06-22 11:17:38
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-22 11:29:32
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=628 lang=java
 *
 * [628] 三个数的最大乘积
 */

// @lc code=start
class Solution {
    public int maximumProduct(int[] nums) {
        /**
         * 都是正数 找3个最大值
         * 都是负数 找3个最大值
         * 有正数有负数 2个最小值1个最大值 vs 3个最大值
         * 
         * 维护5个变量
         */
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 遍历过程中维护变量
            int cur = nums[i];
            if (cur > max1) {
                // 当前值为最大
                max3 = max2;
                max2 = max1;
                max1 = cur;
            } else if (cur > max2) {
                // 当前值为第二大
                max3 = max2;
                max2 = cur;
            } else if (cur > max3) {
                // 当前值为第三大
                max3 = cur;
            }

            if (cur < min1) {
                // 当前值为最小值
                min2 = min1;
                min1 = cur;
            } else if (cur < min2) {
                // 当前值为第二小
                min2 = cur;
            }
        }
        return Math.max((max1 * max2 * max3), (max1 * min1 * min2));
    }
}
// @lc code=end
