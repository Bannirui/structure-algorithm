/*
 * @lc app=leetcode.cn id=289 lang=java
 *
 * [289] 生命游戏
 */

// @lc code=start
class Solution {
    public void gameOfLife(int[][] board) {
        int R = board.length;
        int C = board[0].length;
        // 拷贝一份数组 用来计算周围细胞数量
        int[][] copyBoard = this.copy(board);
        // 遍历原数组
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 周围细胞情况
                int[] aroundCnt = this.cnt(copyBoard, i, j);
                int aroundLiveCnt = aroundCnt[1];
                int aroundDeadCnt = aroundCnt[0];
                if (board[i][j] == 1) {
                    // 当前细胞是活
                    if (aroundLiveCnt < 2) {
                        // 规则1
                        board[i][j] = 0;
                    } else if (aroundLiveCnt == 2 || aroundLiveCnt == 3) {
                        // 规则2
                        // todo
                    } else if (aroundLiveCnt > 3) {
                        // 规则3
                        board[i][j] = 0;
                    }
                } else {
                    // 当前细胞是死
                    if (aroundLiveCnt == 3) {
                        // 规则4
                        board[i][j] = 1;
                    }
                }
            }
        }
    }

    private int[][] copy(int[][] board) {
        int R = board.length;
        int C = board[0].length;
        int[][] copyBoard = new int[R][C];
        // 遍历元素
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                copyBoard[i][j] = board[i][j];
            }
        }
        return copyBoard;
    }

    // 统计[row, col]周围死/活细胞的数量 int[死, 活]
    private int[] cnt(int[][] board, int row, int col) {
        int ROWS = board.length;
        int COLS = board[0].length;
        int liveCnt = 0;
        int deadCnt = 0;
        // 边界
        // 左上
        if (row - 1 >= 0 && col - 1 >= 0) {
            if (board[row - 1][col - 1] == 1) {
                liveCnt++;
            } else {
                deadCnt++;
            }
        }
        // 上
        if (row - 1 >= 0) {
            if (board[row - 1][col] == 1) {
                liveCnt++;
            } else {
                deadCnt++;
            }
        }
        // 右上
        if (row - 1 >= 0 && col + 1 < COLS) {
            if (board[row - 1][col + 1] == 1) {
                liveCnt++;
            } else {
                deadCnt++;
            }
        }
        // 右
        if (col + 1 < COLS) {
            if (board[row][col + 1] == 1) {
                liveCnt++;
            } else {
                deadCnt++;
            }
        }
        // 右下
        if (row + 1 < ROWS && col + 1 < COLS) {
            if (board[row + 1][col + 1] == 1) {
                liveCnt++;
            } else {
                deadCnt++;
            }
        }
        // 下
        if (row + 1 < ROWS) {
            if (board[row + 1][col] == 1) {
                liveCnt++;
            } else {
                deadCnt++;
            }
        }
        // 左下
        if (row + 1 < ROWS && col - 1 >= 0) {
            if (board[row + 1][col - 1] == 1) {
                liveCnt++;
            } else {
                deadCnt++;
            }
        }
        // 左
        if (col - 1 >= 0) {
            if (board[row][col - 1] == 1) {
                liveCnt++;
            } else {
                deadCnt++;
            }
        }
        return new int[] { deadCnt, liveCnt };
    }
}
// @lc code=end
