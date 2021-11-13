/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {

    private int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public int numIslands(char[][] grid) {
        int cnt=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    cnt++;
                    this.dfs(grid,i,j);
                }
            }
        }
        return cnt;
    }

    // 1->2
    private void dfs(char[][] grid, int x, int y){
        if(grid[x][y]!='1'){
            return;
        }
        grid[x][y]='2';
        for(int[] direction: this.directions){
            int newX = x+direction[0];
            int newY = y+direction[1];
            if(0<=newX && newX<grid.length && 0<=newY && newY<grid[0].length){
                this.dfs(grid, newX, newY);
            }
        }
    }
}
// @lc code=end

