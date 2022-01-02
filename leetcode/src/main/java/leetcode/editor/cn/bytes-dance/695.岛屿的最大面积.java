/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
class Solution {

    private int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public int maxAreaOfIsland(int[][] grid) {
        int ret =0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    ret = Math.max(ret, this.dfs(grid, i, j));
                }
            }
        }
        return ret;
    }

    // find all 1 and convert to 2
    private int dfs(int[][] grid, int i, int j){ // i and j is always valid
        if(grid[i][j] != 1) return 0;
        int ret=1;
        grid[i][j] = 2;
        for(int[] direction: directions){
            int newI = i+direction[0];
            int newJ = j+direction[1];
            if(0<=newI && newI<grid.length && 0<=newJ && newJ<grid[0].length){
                ret += this.dfs(grid, newI, newJ);
            }
        }
        return ret;
    }
}
// @lc code=end

