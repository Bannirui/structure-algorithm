/*
 * @Author: dingrui
 * @Date: 2021-07-05 15:44:06
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-06 15:16:43
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1266 lang=java
 *
 * [1266] 访问所有点的最小时间
 */

// @lc code=start
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        for (int r = 0; r < points.length - 1; r++) {
            int[] point1 = points[r];
            int[] point2 = points[r + 1];
            res += Math.max(Math.abs(point2[0] - point1[0]), Math.abs(point2[1] - point1[1]));
        }
        return res;
    }
}
// @lc code=end
