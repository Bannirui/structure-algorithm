/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {

    // 4个方向 左 右 下 上
    private int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public int numIslands(char[][] grid) {
        // 遍历找1 找到1进行感染为2
        int cnt=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    cnt++;
                    // 找到1 进行感染
                    this.dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

    // grid中[r, c]出发 找到1就感染为2
    private void dfs(char[][] grid, int r, int c){
        // base case
        if(r<0||r>=grid.length||c<0||c>=grid[0].length){
            return;
        }
        // 当前1改为2
        if(grid[r][c]=='1'){
            grid[r][c]='2';
            // dfs
            for(int[] direction: directions){
                int newR = r+direction[0];
                int newC = c+direction[1];
                this.dfs(grid, newR, newC);
            }
        }
    }
}
// @lc code=end

