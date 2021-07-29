/*
 * @Author: dingrui
 * @Date: 2021-07-29 16:22:58
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-29 16:44:02
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // 双指针
        int l = 0, r = -1;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        while (l < nums.length || r < nums.length) {
            if (sum < target) {
                // 右指针右移
                if (r + 1 < nums.length) {
                    r++;
                    sum += nums[r];
                } else {
                    break;
                }
            } else {
                // 记录当前长度
                res = Math.min(res, r - l + 1);
                if (l + 1 < nums.length) {
                    // 左指针右移
                    sum -= nums[l];
                    l++;
                } else {
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
// @lc code=end
