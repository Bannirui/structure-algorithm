/*
 * @Author: dingrui
 * @Date: 2021-06-28 17:37:25
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-28 17:43:56
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=867 lang=java
 *
 * [867] 转置矩阵
 */

// @lc code=start
class Solution {
    public int[][] transpose(int[][] matrix) {
        // 行列交换
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] res = new int[cols][rows];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                res[c][r] = matrix[r][c];
            }
        }
        return res;
    }
}
// @lc code=end
