/*
 * @Author: dingrui
 * @Date: 2021-07-08 13:49:51
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-08 13:58:36
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1470 lang=java
 *
 * [1470] 重新排列数组
 */

// @lc code=start
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[n * 2];
        for (int i = 0, j = 0; i < n; i++, j += 2) {
            res[j] = nums[i];
            res[j + 1] = nums[i + n];
        }
        return res;
    }
}
// @lc code=end
