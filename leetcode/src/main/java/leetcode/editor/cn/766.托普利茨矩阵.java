/*
 * @Author: dingrui
 * @Date: 2021-06-25 14:40:30
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-25 15:47:09
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=766 lang=java
 *
 * [766] 托普利茨矩阵
 */

// @lc code=start
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        // start点从左下角向上出发 end点从左下角向右出发
        int rows = matrix.length;
        int cols = matrix[0].length;
        int startRow = rows - 1;
        int startCol = 0;
        int endRow = rows - 1;
        int endCol = 0;
        // 直到运动到右上角的点为止
        while (startCol != (cols - 1) && endRow != 0) {
            int[] start = new int[] { startRow, startCol };
            int[] end = new int[] { endRow, endCol };
            if (!isToeplitzByTwoPoint(matrix, start, end)) {
                return false;
            }
            int oldStartRow = startRow;
            startRow = (oldStartRow == 0) ? 0 : startRow - 1;
            startCol = (oldStartRow == 0) ? startCol + 1 : 0;
            int oldEndCol = endCol;
            endRow = (oldEndCol == cols - 1) ? endRow - 1 : rows - 1;
            endCol = (oldEndCol == cols - 1) ? cols - 1 : endCol + 1;
        }
        return true;

    }

    // 给定两个起止点 判断这一条线上的值是不是都一样
    private boolean isToeplitzByTwoPoint(int[][] matrix, int[] start, int[] end) {
        int startRow = start[0];
        int startCol = start[1];
        int endRow = end[0];
        int endCol = end[1];
        // 两个点重合
        if (startRow == endRow && startCol == endCol) {
            return true;
        }
        // 两点一线上的值都相等 以start点的值为参考
        int base = matrix[startRow][startCol];
        for (int r = startRow, c = startCol; r <= endRow;) {
            if (matrix[r][c] != base) {
                return false;
            }
            r++;
            c++;
        }
        return true;
    }
}
// @lc code=end
