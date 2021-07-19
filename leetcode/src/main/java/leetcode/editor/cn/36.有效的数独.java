/*
 * @Author: dingrui
 * @Date: 2021-07-19 17:32:48
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-19 18:13:45
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 检测行
        for (int i = 0; i < board.length; i++) {
            if (!this.existsMostOnce(board, new int[] { i, 0 }, new int[] { i, 8 })) {
                return false;
            }
        }
        // 检测列
        for (int j = 0; j < board[0].length; j++) {
            if (!this.existsMostOnce(board, new int[] { 0, j }, new int[] { 8, j })) {
                return false;
            }
        }
        // 九宫格检测
        int startR = 0, startC = 0;
        int endR = 2, endC = 2;
        for (int deltaR = 0; deltaR <= 6; deltaR += 3) {
            for (int deltaC = 0; deltaC <= 6; deltaC += 3) {
                if (!this.existsMostOnce(board, new int[] { startR + deltaR, startC + deltaC },
                        new int[] { endR + deltaR, endC + deltaC })) {
                    return false;
                }
            }
        }
        return true;
    }

    // 判断是否是数字 [0...9]
    private boolean isDigit(char c) {
        return c - '0' >= 0 && '9' - c >= 0;
    }

    // 在nums中
    // start到end中每个数字只出现了一次
    private boolean existsMostOnce(char[][] nums, int[] start, int[] end) {
        int[] count = new int[10];
        int startRow = start[0];
        int startCol = start[1];
        int endRow = end[0];
        int endCol = end[1];
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                char curChar = nums[i][j];
                if (this.isDigit(curChar)) {
                    if (count[curChar - '0'] >= 1) {
                        return false;
                    }
                    count[curChar - '0']++;
                }
            }
        }
        return true;
    }
}
// @lc code=end
