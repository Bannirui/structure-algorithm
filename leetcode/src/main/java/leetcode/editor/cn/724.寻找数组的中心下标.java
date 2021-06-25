/*
 * @Author: dingrui
 * @Date: 2021-06-25 13:53:51
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-25 14:00:32
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=724 lang=java
 *
 * [724] 寻找数组的中心下标
 */

// @lc code=start
class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 左和=右和 ->总和=左和+右和+自己
        int len = nums.length;
        int sum = 0;
        // sum
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        // find index
        int tmpSum = 0;
        for (int i = 0; i < len; i++) {
            if ((tmpSum << 1) + nums[i] == sum) {
                return i;
            }
            tmpSum += nums[i];
        }
        return -1;
    }
}
// @lc code=end
