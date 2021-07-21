import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

/*
 * @Author: dingrui
 * @Date: 2021-07-21 15:25:35
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-21 15:46:08
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        boolean[] rowRecord = new boolean[ROWS];
        boolean[] colRecord = new boolean[COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (matrix[i][j] == 0) {
                    rowRecord[i] = true;
                    colRecord[j] = true;
                }
            }
        }
        // 置0
        for (int i = 0; i < ROWS; i++) {
            if (rowRecord[i]) {
                for (int j = 0; j < COLS; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < COLS; j++) {
            if (colRecord[j]) {
                for (int i = 0; i < ROWS; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
// @lc code=end
