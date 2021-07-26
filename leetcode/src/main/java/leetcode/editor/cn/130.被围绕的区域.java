import java.util.function.BiPredicate;

/*
 * @Author: dingrui
 * @Date: 2021-07-26 09:43:23
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-26 10:11:03
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        // 边界上的O是不需要改成X的
        // 第一行和最后一行
        for (int c = 0; c < board[0].length; c++) {
            this.dfs(board, 0, c);
            this.dfs(board, board.length - 1, c);
        }
        // 第一列和最后一列
        for (int r = 0; r < board.length; r++) {
            this.dfs(board, r, 0);
            this.dfs(board, r, board[0].length - 1);
        }
        // 遍历 把不需要改O的再改回来 其余改成X
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'P') {
                    board[r][c] = 'O';
                } else if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
    }

    // 出发找不需要改成X的O
    // 把这些O先改成P
    private void dfs(char[][] board, int r, int c) {
        // base case
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return;
        }
        if (board[r][c] != 'O') {
            return;
        }
        // 感染周边区域
        board[r][c] = 'P';
        // 上
        dfs(board, r - 1, c);
        // 下
        dfs(board, r + 1, c);
        // 左
        dfs(board, r, c - 1);
        // 右
        dfs(board, r, c + 1);
    }
}
// @lc code=end
