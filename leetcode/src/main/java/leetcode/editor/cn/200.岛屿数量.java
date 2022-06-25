/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {

    char[][] grid;
    int rows;
    int cols;
    int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public int numIslands(char[][] grid) {
        int rows=0, cols=0;
        if(grid==null || (rows=grid.length)==0 || (cols=grid[0].length)==0) throw new IllegalArgumentException();
        this.grid=grid;
        this.rows=rows;
        this.cols=cols;
        int ret=0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(this.grid[i][j]=='1'){
                    ret++;
                    this.dfs(i, j);
                }
            }
        }
        return ret;
    }

    private void dfs(int x, int y){
        if(this.grid[x][y]!='1') return;
        this.grid[x][y]='2';
        for(int[] direction: this.directions){
            int nX = x+direction[0];
            int nY = y+direction[1];
            if(nX<0||nX>=this.rows||nY<0||nY>=this.cols) continue;
            this.dfs(nX,nY);
        }
    }
}
// @lc code=end

