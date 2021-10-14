/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution
{
    public boolean isValidSudoku(char[][] board)
    {
        // 9*9
        int rows = board.length;
        int cols = board[0].length;
        // row col 3*3
        int[][] rowCount = new int[9][10];
        int[][] colCount = new int[9][10];
        int[][][] subCount = new int[3][3][10];
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < cols; c++)
            {
                char curCh = board[r][c];
                if (curCh != '.')
                {
                    // digit 1-9
                    int idx = curCh - '0';
                    // update
                    rowCount[r][idx]++;
                    colCount[c][idx]++;
                    subCount[r / 3][c / 3][idx]++;
                    // check
                    if (rowCount[r][idx] > 1 || colCount[c][idx] > 1 || subCount[r / 3][c / 3][idx] > 1)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
// @lc code=end
