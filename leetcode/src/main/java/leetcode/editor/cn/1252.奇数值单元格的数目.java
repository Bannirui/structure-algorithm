/*
 * @Author: dingrui
 * @Date: 2021-07-05 10:10:45
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-05 14:53:51
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1252 lang=java
 *
 * [1252] 奇数值单元格的数目
 */

// @lc code=start
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        // 暴力解法
        int[][] helpArr = new int[m][n];
        for (int i = 0; i < indices.length; i++) {
            int[] pos = indices[i];
            int R = pos[0];
            int C = pos[1];
            // 行
            for (int c = 0; c < n; c++) {
                helpArr[R][c]++;
            }
            // 列
            for (int r = 0; r < m; r++) {
                helpArr[r][C]++;
            }
        }
        // 计数
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helpArr[i][j] % 2 != 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
// @lc code=end
