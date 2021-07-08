/*
 * @Author: dingrui
 * @Date: 2021-07-08 13:44:38
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-08 13:48:50
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1464 lang=java
 *
 * [1464] 数组中两元素的最大乘积
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        // 找最大值
        int firMax = Integer.MIN_VALUE, secMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            if (curNum > firMax) {
                secMax = firMax;
                firMax = curNum;
            } else if (curNum > secMax) {
                secMax = curNum;
            }
        }
        return (firMax - 1) * (secMax - 1);
    }
}
// @lc code=end
