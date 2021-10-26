/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        // dfs
        return this.dfs(grid);

        // 并查集
        // todo
    }

    // 并查集

    // #############################################

    // dfs
    private int dfs(char[][] grid) {
        // 水里面找陆地 找到陆地进行感染
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    // 找到了陆地
                    cnt++;
                    // 感染
                    this.dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

    // 把以[row, col]为起点的陆地全部做标识
    private void dfs(char[][] grid, int row, int col) {
        // base case
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1') {
            return;
        }
        // 把找到的陆地标识为2
        grid[row][col] = '2';
        // 感染四周
        this.dfs(grid, row - 1, col);
        this.dfs(grid, row + 1, col);
        this.dfs(grid, row, col - 1);
        this.dfs(grid, row, col + 1);
    }
}
// @lc code=end
