/*
 * @Author: dingrui
 * @Date: 2021-06-29 13:42:53
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-29 13:48:49
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=922 lang=java
 *
 * [922] 按奇偶排序数组 II
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int[] res = new int[nums.length];
        int singleIndex = 1, doubleIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                // 偶数
                res[doubleIndex] = nums[i];
                doubleIndex += 2;
            } else {
                // 奇数
                res[singleIndex] = nums[i];
                singleIndex += 2;
            }
        }
        return res;
    }
}
// @lc code=end
