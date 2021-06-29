/*
 * @Author: dingrui
 * @Date: 2021-06-29 11:14:36
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-29 11:19:43
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=892 lang=java
 *
 * [892] 三维形体的表面积
 */

// @lc code=start
class Solution {
    public int surfaceArea(int[][] grid) {
        int[] dr = new int[] { 0, 1, 0, -1 };
        int[] dc = new int[] { 1, 0, -1, 0 };
        int len = grid.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (grid[i][j] > 0) {
                    res += 2;
                    for (int k = 0; k < 4; k++) {
                        int newR = i + dr[k];
                        int newC = j + dc[k];
                        int nv = 0;
                        if (0 <= newR && newR < len && 0 <= newC && newC < len) {
                            nv = grid[newR][newC];
                        }
                        res += Math.max(grid[i][j] - nv, 0);
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end
