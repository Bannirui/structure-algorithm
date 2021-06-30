/*
 * @Author: dingrui
 * @Date: 2021-06-30 14:19:21
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-30 14:42:58
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1005 lang=java
 *
 * [1005] K 次取反后最大化的数组和
 */

// @lc code=start
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 找到最小值 换成新数组
        int sum = 0;
        int minValue = Integer.MAX_VALUE;
        int minValueIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] < minValue) {
                minValueIndex = i;
                minValue = nums[i];
            }
        }
        if (k == 0) {
            return sum;
        }
        // 新组数
        nums[minValueIndex] = 0 - minValue;
        return largestSumAfterKNegations(nums, k - 1);
    }
}
// @lc code=end
