/*
 * @Author: dingrui
 * @Date: 2021-07-20 16:56:43
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-20 18:22:57
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        // 顺时针旋转 一圈一圈的转 从外层->内层
        // 左上角的点 右下角的点 逼近
        int start = 0, end = matrix.length - 1;
        while (start < end) {
            this.transfer(matrix, start, start, end, end);
            start++;
            end--;
        }

    }

    // 在matrix中顺时针循环[startRow, startCol]到[endRow, endCol]一层
    private void transfer(int[][] matrix, int startRow, int startCol, int endRow, int endCol) {
        int times = endRow - startRow;
        // 每次转4个元素 一条边上有N个元素 就需要转N-1次
        int tmp = 0;
        for (int i = 0; i < times; i++) {
            tmp = matrix[startRow][startCol + i];
            matrix[startRow][startCol + i] = matrix[endRow - i][startCol];
            matrix[endRow - i][startCol] = matrix[endRow][endCol - i];
            matrix[endRow][endCol - i] = matrix[startRow + i][endCol];
            matrix[startRow + i][endCol] = tmp;
        }
    }
}
// @lc code=end
