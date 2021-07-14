/*
 * @Author: dingrui
 * @Date: 2021-07-14 13:04:21
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-14 13:17:07
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int mostRightIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= mostRightIndex) {
                // 来到i位置 可以跳跃nums[i]
                mostRightIndex = Math.max(mostRightIndex, i + nums[i]);
                if (mostRightIndex >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end
