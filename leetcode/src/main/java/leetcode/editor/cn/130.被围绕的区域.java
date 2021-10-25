/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {

    int rows, cols;

    public void solve(char[][] board) {
        // base case
        if (board == null || (this.rows = board.length) == 0) {
            return;
        }
        this.cols = board[0].length;
        // 4个边上的'O'作为起始点进行感染 都不需要变成'X'
        for (int i = 0; i < this.rows; i++) {
            // [i, 0] [i, cols-1]
            this.dfs(board, i, 0);
            this.dfs(board, i, this.cols - 1);
        }
        for (int i = 1; i < this.cols - 1; i++) {
            // [0, i] [rows-1, i]
            this.dfs(board, 0, i);
            this.dfs(board, rows - 1, i);
        }
        // 感染完 不需要变化的'O'现在为'Z' 需要变化的'O'改成'X'
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                char curChar = board[i][j];
                if ('Z' == curChar) {
                    board[i][j] = 'O';
                } else if ('O' == curChar) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    // 从[i, j]出发 感染'O' 变成'Z'
    private void dfs(char[][] board, int i, int j) {
        // base case
        if (i < 0 || i >= this.rows || j < 0 || j >= this.cols || board[i][j] != 'O') {
            // 不需要感染
            return;
        }
        // 需要感染 标识为'Z'
        board[i][j] = 'Z';
        // 上
        this.dfs(board, i - 1, j);
        // 下
        this.dfs(board, i + 1, j);
        // 左
        this.dfs(board, i, j - 1);
        // 右
        this.dfs(board, i, j + 1);
    }
}
// @lc code=end
