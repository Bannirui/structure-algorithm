/*
 * @Author: dingrui
 * @Date: 2021-07-09 13:02:45
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-09 13:14:18
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1572 lang=java
 *
 * [1572] 矩阵对角线元素的和
 */

// @lc code=start
class Solution {
    public int diagonalSum(int[][] mat) {
        // 正方形 行数=列数
        int ROW = mat.length;
        int res = 0;
        // 坐标(r,c) 主对角线->r+c==ROW 副对角线->r==c 中心坐标(ROW/2, ROW/2)
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < ROW; c++) {
                if (r == c || (r + c == (ROW - 1))) {
                    res += mat[r][c];
                }
            }
        }
        return res;
    }
}
// @lc code=end
