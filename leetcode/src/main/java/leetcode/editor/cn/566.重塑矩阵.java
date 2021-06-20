/*
 * @Author: dingrui
 * @Date: 2021-06-20 10:16:37
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-20 10:26:56
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=566 lang=java
 *
 * [566] 重塑矩阵
 */

// @lc code=start
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        // element counts
        int rows = mat.length;
        int cols = mat[0].length;
        if ((rows * cols) != (r * c)) {
            return mat;
        }
        // reshape
        int[] tmp = new int[rows * cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tmp[index++] = mat[i][j];
            }
        }
        int[][] res = new int[r][c];
        index = 0;
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                res[row][col] = tmp[index++];
            }
        }
        return res;
    }
}
// @lc code=end
