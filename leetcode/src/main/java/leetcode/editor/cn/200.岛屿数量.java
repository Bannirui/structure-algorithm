/*
 * @Author: dingrui
 * @Date: 2021-07-29 11:32:58
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-29 11:49:25
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int counts = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    // 是岛屿
                    counts += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return counts;
    }

    // 从[row][col]出发进行感染 将1->0
    private void dfs(char[][] grid, int row, int col) {
        // base case
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            // 0表示水域 将访问过的也标识为0 就可以省掉一个visited数组
            return;
        }
        // 当前是一个没有访问过的1
        // 将当前1标识为0 表示已经访问过
        grid[row][col] = '0';
        // 递归
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}
// @lc code=end
