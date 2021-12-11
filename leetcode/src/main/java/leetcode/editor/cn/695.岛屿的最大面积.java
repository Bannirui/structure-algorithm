/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
class Solution {

    private int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxCnt = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    maxCnt = Math.max(maxCnt, dfs(grid,i,j));
                }
            }
        }
        return maxCnt;
    }

    private int dfs(int[][] grid, int r, int c){
        // base case
        if(r<0||r>=grid.length||c<0||c>=grid[0].length||grid[r][c]!=1){
            return 0;
        }
        // 1->2
        int cnt=1;
        grid[r][c] = 2;
        for(int[] direction: directions){
            int nR = r+direction[0];
            int nC = c+direction[1];
            cnt += this.dfs(grid, nR, nC);
        }
        return cnt;
    }
}
// @lc code=end

