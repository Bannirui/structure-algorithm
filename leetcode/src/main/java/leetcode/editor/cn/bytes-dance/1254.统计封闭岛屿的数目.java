/*
 * @lc app=leetcode.cn id=1254 lang=java
 *
 * [1254] 统计封闭岛屿的数目
 */

// @lc code=start
class Solution {

    int[][] directions=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public int closedIsland(int[][] grid) {
        int ROWS=0, COLS=0;
        if(grid==null||(ROWS=grid.length)==0||(COLS=grid[0].length)==0) throw new IllegalArgumentException();
        for(int i=0;i<COLS;i++){
            this.dfs(grid, 0, i);
            this.dfs(grid, ROWS-1, i);
        }
        for(int i=0;i<ROWS;i++){
            this.dfs(grid,i,0);
            this.dfs(grid,i,COLS-1);
        }
        int ret=0;
        for(int i=1;i<ROWS-1;i++){
            for(int j=1;j<COLS-1;j++){
                if(grid[i][j]==0){
                    ret++;
                    this.dfs(grid,i,j);
                }
            }
        }
        return ret;
    }

    private void dfs(int[][] grid, int x, int y){
        // base case
        if(grid[x][y]!=0) return;
        grid[x][y]=-1;
        for(int[] direction: directions){
            int deltaX=direction[0];
            int deltaY=direction[1];
            int newX=x+deltaX;
            int newY=y+deltaY;
            if(newX>=0&&newX<grid.length&&newY>=0&&newY<grid[0].length) this.dfs(grid, newX, newY);
        }
    }
}
// @lc code=end

