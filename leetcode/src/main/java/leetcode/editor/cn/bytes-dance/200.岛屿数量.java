/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {

    private int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public int numIslands(char[][] grid) {
        int ROWS=0, COLS=0;
        if(grid==null || (ROWS=grid.length)==0 || (COLS=grid[0].length)==0) throw new IllegalArgumentException();
        int cnt = 0;
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(grid[i][j]=='1'){
                    cnt++;
                    this.infect(grid, i, j);
                }
            }
        }
        // recover
        this.recover(grid);
        return cnt;
    }

    // 1->2
    private void infect(char[][] grid, int x, int y)
    {
        // base case
        if(x<0||x>=grid.length||y<0||y>=grid[0].length||grid[x][y]!='1') return;
        // grid[x][y] 1->2
        grid[x][y]='2';
        // dfs
        for(int[] direction: directions) this.infect(grid, x+direction[0], y+direction[1]);
    }

    // 2->1
    private void recover(char[][] grid)
    {
        int ROWS=0, COLS=0;
        if(grid==null || (ROWS=grid.length)==0 || (COLS=grid[0].length)==0) return;
        for(int i=0;i<ROWS;i++)
            for(int j=0;j<COLS;j++)
                if(grid[i][j]=='2') grid[i][j]='1';
    }
}
// @lc code=end

