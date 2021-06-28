/*
 * @Author: dingrui
 * @Date: 2021-06-25 15:50:09
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-28 15:53:48
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=812 lang=java
 *
 * [812] 最大三角形面积
 */

// @lc code=start
class Solution {
    public double largestTriangleArea(int[][] points) {
        double res = 0;
        // 每3个点一个三角形 面积
        int len = points.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    // 面积
                    double area = area(points[i], points[j], points[k]);
                    res = Math.max(area, res);
                }
            }
        }
        return res;
    }

    public double area(int[] P, int[] Q, int[] R) {
        return 0.5 * Math.abs(P[0] * Q[1] + Q[0] * R[1] + R[0] * P[1] - P[1] * Q[0] - Q[1] * R[0] - R[1] * P[0]);
    }
}
// @lc code=end
