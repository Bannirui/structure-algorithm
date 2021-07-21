/*
 * @Author: dingrui
 * @Date: 2021-07-21 13:48:59
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-21 14:12:34
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        // 生成二维矩阵 长=n
        int[][] res = new int[n][n];
        // 转圈填数字 左上角->右下角 向中间逼近
        int startPos = 0, endPos = n - 1;
        // 填充的数字起始点
        int low = 1;
        while (startPos <= endPos) {
            this.fill(res, startPos, endPos, low);
            // 一圈下来 一条边上(n-1)个数字 4条边
            low += (startPos == endPos ? 1 : (endPos - startPos) * 4);
            startPos++;
            endPos--;
        }
        return res;
    }

    private void fill(int[][] matrix, int startPos, int endPos, int low) {
        int startRow = startPos, startCol = startPos;
        int endRow = endPos, endCol = endPos;
        // 一个点
        if (startPos == endPos) {
            matrix[startRow][startCol] = low;
            return;
        }
        // 从[startRow, startCol]->[endRow, endCol] 顺时针填充
        int r = startRow, c = startCol;
        int startNum = low;
        // 左上->右上
        while (c != endCol) {
            matrix[r][c++] = startNum++;
        }
        // 右上->右下
        while (r != endRow) {
            matrix[r++][c] = startNum++;
        }
        // 右下->左下
        while (c != startCol) {
            matrix[r][c--] = startNum++;
        }
        // 左下->左上
        while (r != startRow) {
            matrix[r--][c] = startNum++;
        }
    }
}
// @lc code=end
