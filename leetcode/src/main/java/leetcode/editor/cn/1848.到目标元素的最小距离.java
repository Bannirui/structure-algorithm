/*
 * @Author: dingrui
 * @Date: 2021-07-12 20:09:16
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 20:11:49
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1848 lang=java
 *
 * [1848] 到目标元素的最小距离
 */

// @lc code=start
class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res = Math.min(res, Math.abs(i - start));
            }
        }
        return res;
    }
}
// @lc code=end
