/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution
{

    private String word;

    public boolean exist(char[][] board, String word)
    {
        this.word = word;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                boolean res = this.dfs(board, i, j, visited, 0);
                if (res)
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, boolean[][] visited, int idx)
    {
        // base case
        if (idx == this.word.length())
        {
            return true;
        }
        // param check
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
        {
            return false;
        }
        // (row, col)
        boolean res = false;
        if (!visited[row][col] && this.word.charAt(idx) == board[row][col])
        {
            // 访问标识
            visited[row][col] = true;
            boolean up = this.dfs(board, row - 1, col, visited, idx + 1);
            boolean down = this.dfs(board, row + 1, col, visited, idx + 1);
            boolean left = this.dfs(board, row, col - 1, visited, idx + 1);
            boolean right = this.dfs(board, row, col + 1, visited, idx + 1);
            res = up || down || left || right;
            // 还原现场
            visited[row][col] = false;
            return res;
        }
        return res;
    }
}
// @lc code=end
