/*
 * @Author: dingrui
 * @Date: 2021-07-28 15:50:06
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-28 15:55:27
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int index = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                // i...i+1降序 i+1就是最小是
                index = i + 1;
                break;
            }
        }
        return index == Integer.MAX_VALUE ? nums[0] : nums[index];
    }
}
// @lc code=end
