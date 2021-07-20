import java.security.spec.EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-20 22:29:45
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-20 22:50:50
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {

    List<Integer> res = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        // 左上角->右下角 逼近中间
        int startRow = 0, startCol = 0;
        int endRow = matrix.length - 1, endCol = matrix[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            this.print(matrix, startRow++, startCol++, endRow--, endCol--);
        }
        return this.res;
    }

    private void print(int[][] matrix, int startRow, int startCol, int endRow, int endCol) {
        int r = startRow, c = startCol;
        // 只有一行
        if (startRow == endRow) {
            while (c <= endCol) {
                this.res.add(matrix[r][c++]);
            }
        } else if (startCol == endCol) {
            // 只有一列
            while (r <= endRow) {
                this.res.add(matrix[r++][c]);
            }
        } else {
            // 普遍情况
            // 左上角->右上角
            while (c != endCol) {
                this.res.add(matrix[r][c++]);
            }
            // 右上角->右下角
            while (r != endRow) {
                this.res.add(matrix[r++][c]);
            }
            // 右下角->左下角
            while (c != startCol) {
                this.res.add(matrix[r][c--]);
            }
            // 右下角->左上角
            while (r != startRow) {
                this.res.add(matrix[r--][c]);
            }
        }
    }
}
// @lc code=end
