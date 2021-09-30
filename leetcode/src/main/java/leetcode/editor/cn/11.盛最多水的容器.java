/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        // base case
        int len = 0;
        if (height == null || (len = height.length) == 0) {
            return 0;
        }
        // 双指针L和R 容量=min(L', R')*(R-L)
        int max = 0;
        int L = 0, R = height.length - 1;
        while (L < R) {
            int cur = Math.min(height[L], height[R]) * (R - L);
            max = Math.max(max, cur);
            // 移动矮的脚标 才有可能出现更大值
            if (height[L] <= height[R]) {
                L++;
            } else {
                R--;
            }
        }
        return max;
    }
}
// @lc code=end
