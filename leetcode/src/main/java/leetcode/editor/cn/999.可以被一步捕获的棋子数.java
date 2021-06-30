/*
 * @Author: dingrui
 * @Date: 2021-06-30 13:33:10
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-30 14:02:07
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=999 lang=java
 *
 * [999] 可以被一步捕获的棋子数
 */

// @lc code=start
class Solution {
    public int numRookCaptures(char[][] board) {
        // 只有一个白车
        int rows = board.length;
        int cols = board[0].length;
        int startRow = 0, startCol = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'R') {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        return dfs(board, rows, cols, startRow, startCol, 0, ' ');
    }

    private int dfs(char[][] board, int rows, int cols, int row, int col, int count, char direction) {
        // base case
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return count;
        }
        // 现在来到的位置
        char c = board[row][col];
        if (c == '.') {
            // 空格 继续
            if (direction == 'u') {
                int u = dfs(board, rows, cols, row - 1, col, count, 'u');
                return count + u;
            } else if (direction == 'd') {
                int d = dfs(board, rows, cols, row + 1, col, count, 'd');
                return count + d;
            } else if (direction == 'l') {
                int l = dfs(board, rows, cols, row, col - 1, count, 'l');
                return count + l;
            } else if (direction == 'r') {
                int r = dfs(board, rows, cols, row, col + 1, count, 'r');
                return count + r;
            } else {
                // 不存在
            }
        } else if (c == 'B') {
            // 白象 停止
            return count;
        } else if (c == 'p') {
            // 黑卒 停止
            return count + 1;
        } else {
            // 白车 出发位置
            int u = dfs(board, rows, cols, row - 1, col, count, 'u');
            int d = dfs(board, rows, cols, row + 1, col, count, 'd');
            int l = dfs(board, rows, cols, row, col - 1, count, 'l');
            int r = dfs(board, rows, cols, row, col + 1, count, 'r');
            return count + u + d + l + r;
        }
        return count;
    }
}
// @lc code=end
