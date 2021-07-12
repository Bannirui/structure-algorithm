/*
 * @Author: dingrui
 * @Date: 2021-07-12 16:08:26
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 16:16:05
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1779 lang=java
 *
 * [1779] 找到最近的有相同 X 或 Y 坐标的点
 */

// @lc code=start
class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minDistance = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int curDistance = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if (curDistance < minDistance) {
                    minDistance = curDistance;
                    res = i;
                }
            }
        }
        return res;
    }
}
// @lc code=end
