/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {

    private int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public int numIslands(char[][] grid) {
        int cnt = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    // cnt
                    cnt++;
                    this.infect(grid, i, j);
                }
            }
        }
        return cnt;
    }

    // 1->2
    private void infect(char[][] grid, int x, int y){
        // base case
        if(x<0||x>=grid.length||y<0||y>=grid[0].length||grid[x][y]!='1'){
            return;
        }
        // grid[x][y] 1->2
        grid[x][y]='2';
        // dfs
        for(int[] direction: directions){
            int newX = x+direction[0];
            int newY = y+direction[1];
            this.infect(grid, newX, newY);
        }
    }
}
// @lc code=end

