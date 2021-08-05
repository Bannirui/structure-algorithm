import javax.swing.text.AbstractDocument.BranchElement;

/*
 * @Author: dingRui
 * @Date: 2021-08-03 17:36:05
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-05 09:41:40
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=289 lang=java
 *
 * [289] 生命游戏
 */

// @lc code=start
class Solution {
    public void gameOfLife(int[][] board) {
        int length = board.length, width = board[0].length;
        // copy
        int[][] copy = new int[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                copy[i][j] = board[i][j];
            }
        }
        // 遍历每个位置
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                int cur = copy[i][j];
                int liveCount = this.aroundLiveCount(copy, i, j);
                if (cur == 0) {
                    // 当前是死细胞
                    board[i][j] = liveCount == 3 ? 1 : 0;
                } else {
                    // 当前是活细胞
                    if (liveCount < 2) {
                        // 活细胞死亡
                        board[i][j] = 0;
                    } else if (liveCount == 2 || liveCount == 3) {
                        // 存活
                        board[i][j] = 1;
                    } else {
                        // 活细胞死亡
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    // 在board中[row, col]周围活细胞的数量
    private int aroundLiveCount(int[][] board, int row, int col) {
        if (!this.validPos(board, row, col)) {
            return -1;
        }
        int count = 0;
        // 上
        if (this.validPos(board, row - 1, col) && board[row - 1][col] == 1) {
            count++;
        }
        // 下
        if (this.validPos(board, row + 1, col) && board[row + 1][col] == 1) {
            count++;
        }
        // 左
        if (this.validPos(board, row, col - 1) && board[row][col - 1] == 1) {
            count++;
        }
        // 右
        if (this.validPos(board, row, col + 1) && board[row][col + 1] == 1) {
            count++;
        }
        // 左上
        if (this.validPos(board, row - 1, col - 1) && board[row - 1][col - 1] == 1) {
            count++;
        }
        // 右上
        if (this.validPos(board, row - 1, col + 1) && board[row - 1][col + 1] == 1) {
            count++;
        }
        // 左下
        if (this.validPos(board, row + 1, col - 1) && board[row + 1][col - 1] == 1) {
            count++;
        }
        // 右下
        if (this.validPos(board, row + 1, col + 1) && board[row + 1][col + 1] == 1) {
            count++;
        }
        return count;
    }

    // 数组脚标溢出检查
    private boolean validPos(int[][] board, int row, int col) {
        int length = board.length;
        int width = board[0].length;
        if (row < 0 || col < 0 || row >= length || col >= width) {
            return false;
        }
        return true;
    }
}
// @lc code=end
